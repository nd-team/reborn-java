package com.bjike.reborn.user.service;

import com.alibaba.fastjson.JSON;
import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.provider.utils.RpcTransmit;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.common.utils.date.DateUtil;
import com.bjike.reborn.redis.client.RedisClient;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.bo.rbac.PermissionAuthBO;
import com.bjike.reborn.user.dto.UserDTO;
import com.bjike.reborn.user.entity.User;
import com.bjike.reborn.user.entity.UserDetail;
import com.bjike.reborn.user.enums.UserType;
import com.bjike.reborn.user.session.constant.UserCommon;
import com.bjike.reborn.user.session.valid_right.LoginUser;
import com.bjike.reborn.user.session.valid_right.UserSession;
import com.bjike.reborn.user.to.UserTO;
import org.apache.commons.lang3.StringUtils;
import org.mengyun.tcctransaction.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@CacheConfig(cacheNames = "userSerCache")
@Service
public class UserSerImpl extends ServiceImpl<User, UserDTO> implements UserSer {
    public static String PUBLIC_KEY;
    public static String PRIVATE_KEY;
    private static Logger LOGGER = LoggerFactory.getLogger(UserSerImpl.class);
    @Autowired
    private UserDetailSer userDetailSer;
    @Autowired
    private RedisClient redis;

    /**
     * 初始化公钥私钥
     */
    static {
        File file = new File("/root/files/key.properties");
        try {
            if (file.exists()) {
                Reader rd = new FileReader(file);
                BufferedReader reader = new BufferedReader(rd);
                String line = null;
                while (null != (line = reader.readLine())) {
                    if (line.startsWith("publicKey")) {
                        PUBLIC_KEY = line.split("=")[1].trim();
                    }
                    if (line.startsWith("privateKey")) {
                        PRIVATE_KEY = line.split("=")[1].trim();
                    }
                }
            } else {
                LOGGER.info("/root/files/key.properties 配置文件不存在,请先创建!");
            }
        } catch (Exception e) {
            LOGGER.info("公钥读取异常!");
        }
    }


    @Override
    public String publicKey() throws SerException {
        return PUBLIC_KEY;
    }

    @Override
    public String privateKey() throws SerException {
        return PRIVATE_KEY;
    }


    @Override
    public UserBO currentUser() throws SerException {
        String token = RpcTransmit.getUserToken();
        LoginUser loginUser = currentLoginUser(token);
        return BeanTransform.copyProperties(loginUser, UserBO.class);

    }

    @Override
    public UserBO currentUser(String userToken) throws SerException {
        LoginUser loginUser = currentLoginUser(userToken);
        return BeanTransform.copyProperties(loginUser, UserBO.class);
    }

    @Override
    public String currentSysNO() throws SerException {
        String sysNO = currentUser().getSystemNO();
        if (StringUtils.isNotBlank(sysNO)) {
            return sysNO;
        } else {
            throw new SerException("当前用户系统号为空!");
        }

    }

    @Override
    public String currentSysNO(String token) throws SerException {
        String sysNO = currentUser(token).getSystemNO();
        if (StringUtils.isNotBlank(sysNO)) {
            return sysNO;
        } else {
            throw new SerException("当前用户系统号为空!");
        }
    }


    @Override
    public List<PermissionAuthBO> currentPermissions() throws SerException {
        String token = RpcTransmit.getUserToken();
        if (null != token) {
            try {
                LoginUser loginUser = currentLoginUser(token);
                return loginUser.getPermissions();
            } catch (SerException e) {
                return new ArrayList<>(0);
            }
        }
        return new ArrayList<>(0);
    }


    private LoginUser currentLoginUser(Object token) throws SerException {
        if (null != token) {
            LoginUser loginUser = UserSession.get(token.toString());
            if (null != loginUser) {
                return loginUser;
            } else { //redis 获取
                String loginUser_str = redis.getMap(UserCommon.LOGIN_USER, token.toString());
                if (StringUtils.isNotBlank(loginUser_str)) {
                    loginUser = JSON.parseObject(loginUser_str, LoginUser.class);
                    UserSession.put(token.toString(), loginUser); //设置到session
                    return loginUser;
                }
            }
            throw new SerException("expire");
        } else {
            throw new SerException("notLogin");
        }
    }


    @Override
    @Transactional(rollbackFor = SerException.class)
    @Compensable(confirmMethod = "addConfirm", cancelMethod = "addCancel")
    public void add(TransactionContext txContext, UserTO userTO) throws SerException {
        UserDTO dto = new UserDTO();
        dto.getConditions().add(Restrict.eq(USERNAME, userTO.getUsername()));
        if (null == super.findOne(dto)) {
            UserBO currentUser = currentUser();
            User user = new User();
            user.setUsername(userTO.getUsername());
            user.setPassword(userTO.getPassword());
            user.setSystemNO(currentUser.getSystemNO());
            user.setStatus(Status.THAW);
            user.setUserType(UserType.EMPLOYEE);
            super.save(user);
            UserDetail detail = BeanTransform.copyProperties(userTO, UserDetail.class);
            if (null != detail) {
                detail.setUser(user);
                userDetailSer.save(detail);
            }
        } else {
            throw new SerException("用户名已被使用!");
        }

    }

    @Transactional(rollbackFor = SerException.class)
    public String addConfirm(TransactionContext txContext, UserTO userTO) throws SerException {
        System.out.println("用户添加确认");
        return null;
    }

    @Transactional(rollbackFor = SerException.class)
    public String addCancel(TransactionContext txContext, UserTO userTO) throws SerException {
        UserDTO dto = new UserDTO();
        dto.getConditions().add(Restrict.eq("username", userTO.getUsername()));
        dto.getConditions().add(Restrict.eq(SYS_NO, currentSysNO()));
        User user = super.findOne(dto);
        if (null != user) {
            super.remove(user);
        }
        return null;
    }

    @Override
    public void delete(String id) throws SerException {
        User user = super.findById(id);
        user.setStatus(Status.DELETE);
        user.setUsername(user.getUsername() + "#" + DateUtil.dateToString(LocalDateTime.now()));
        super.update(user);
    }
}