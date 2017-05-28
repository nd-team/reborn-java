package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.utils.PasswordHash;
import com.bjike.reborn.user.entity.User;
import com.bjike.reborn.user.entity.UserDetail;
import com.bjike.reborn.user.enums.UserType;
import com.bjike.reborn.user.to.UserRegisterTO;
import com.bjike.reborn.user.utils.SeqUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 用户注册业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class UserRegisterSerImpl implements UserRegisterSer {

    @Autowired
    private UserSer userSer;

    /**
     * 通过用户注册数据传输实体保存用户
     *
     * @param registerTO
     * @throws SerException
     */
    @Transactional
    public void register(UserRegisterTO registerTO) throws SerException {
        try {
            String systemNO = userSer.findByMaxField("systemNO", User.class);
            User user = new User();
            user.setUsername(registerTO.getUsername());
            user.setEmail(registerTO.getEmail());
            user.setPassword(PasswordHash.createHash(registerTO.getPassword()));
            user.setCreateTime(LocalDateTime.now());
            user.setSystemNO(SeqUtil.generateSys(systemNO));
            user.setStatus(Status.THAW);
            user.setUserType(UserType.ADMIN);
            userSer.save(user);
        } catch (Exception e) {
            throw new SerException(e.getMessage());
        }
    }



}
