package com.bjike.reborn.storage.service;

import com.alibaba.fastjson.JSON;
import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.jpa.utils.PasswordHash;
import com.bjike.reborn.common.provider.utils.RpcTransmit;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.common.utils.token.TokenUtil;
import com.bjike.reborn.redis.client.RedisClient;
import com.bjike.reborn.storage.bo.StorageUserBO;
import com.bjike.reborn.storage.constant.StorageCommon;
import com.bjike.reborn.storage.dto.StorageUserDTO;
import com.bjike.reborn.storage.entity.StorageUser;
import com.bjike.reborn.storage.session.LoginUser;
import com.bjike.reborn.storage.session.StorageSession;
import com.bjike.reborn.storage.to.StorageUserTO;
import com.bjike.reborn.user.api.UserAPI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * 存储模块用户业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-03-30 09:39 ]
 * @Description: [ 存储模块用户业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "storageSerCache")
@Service
public class StorageUserSerImpl extends ServiceImpl<StorageUser, StorageUserDTO> implements StorageUserSer {

    @Autowired
    private RedisClient redis;
    @Autowired
    private UserAPI userAPI;

    @Override
    public StorageUserBO register(StorageUserTO storageUserTO) throws SerException {
        StorageUserDTO dto = new StorageUserDTO();
        dto.getConditions().add(Restrict.or("moduleName", storageUserTO.getModuleName()));
        dto.getConditions().add(Restrict.or("account", storageUserTO.getAccount()));
        StorageUser storageUser = null;
        if (null == super.findOne(dto)) {
            storageUser = BeanTransform.copyProperties(storageUserTO, StorageUser.class);
            storageUser.setStatus(Status.THAW);
            try {
                storageUser.setPassword(PasswordHash.createHash(storageUser.getPassword()));
            } catch (Exception e) {
                throw new SerException(e.getMessage());
            }
            storageUser.setSystemNO(userAPI.currentSystemNO(storageUserTO.getUserToken()));
            storageUser = super.save(storageUser);
        } else {
            throw new SerException("账号名或者模块名已存在！");
        }
        return BeanTransform.copyProperties(storageUser, StorageUserBO.class);
    }

    @Override
    public String login(StorageUserTO storageUserTO) throws SerException {
        StorageUserDTO dto = new StorageUserDTO();
        dto.getConditions().add(Restrict.eq("account", storageUserTO.getAccount()));
        StorageUser storageUser = findOne(dto);
        if (null != storageUser) {
            try {
                if (PasswordHash.validatePassword(storageUserTO.getPassword(), storageUser.getPassword())) {
                    return login(storageUser);
                }
                throw new SerException("登录账号或者密码错误！");

            } catch (Exception e) {
                throw new SerException("登录账号或者密码错误！");
            }

        } else {
            throw new SerException("登录账号或者密码错误！");
        }
    }

    private String login(StorageUser storageUser) throws SerException {
        String token = TokenUtil.create("192.168.0.1", storageUser.getAccount());
        LoginUser loginUser = BeanTransform.copyProperties(storageUser, LoginUser.class);
        StorageSession.put(token, loginUser);
        String str_loginUser = JSON.toJSONString(loginUser);
        redis.appendToMap(StorageCommon.LOGIN_USER, token, str_loginUser, StorageCommon.LOGIN_TIMEOUT);
        return token;
    }

    @Override
    public Boolean signOut(String storageToken) throws SerException {
        StorageUserBO userBO = getCurrentUser(storageToken);
        StorageSession.remove(storageToken);
        redis.removeMap(StorageCommon.LOGIN_USER, userBO.getId());
        return true;
    }


    @Override
    public StorageUserBO getCurrentUser(String storageToken) throws SerException {
        if (StringUtils.isNotBlank(storageToken)) {
            LoginUser loginUser = StorageSession.get(storageToken);
            if (null != loginUser) {
                return BeanTransform.copyProperties(loginUser, StorageUserBO.class);
            } else {
                String login_user = redis.getMap(StorageCommon.LOGIN_USER, storageToken);
                if (StringUtils.isNotBlank(login_user)) {
                    loginUser = JSON.parseObject(login_user, LoginUser.class);
                    return BeanTransform.copyProperties(loginUser, StorageUserBO.class);
                } else {
                    throw new SerException("登录已失效！");
                }
            }
        }
        throw new SerException("存储用户未登录！");
    }

    @Override
    public String getCurrentModule(String storageToken) throws SerException {
        return this.getCurrentUser(storageToken).getModuleName();
    }

    @Override
    public String getCurrentSysNO(String storageToken) throws SerException {
        return this.getCurrentUser(storageToken).getSystemNO();
    }
}