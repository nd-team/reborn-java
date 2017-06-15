package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.service.UserSer;
import com.bjike.reborn.user.to.UserTO;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-11 15:10]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("userApiImpl")
public class UserApiImpl implements UserAPI {
    @Autowired
    private UserSer userSer;

    @Override
    public String publicKey() throws SerException {
        return userSer.publicKey();

    }

    @Override
    public String privateKey() throws SerException {
        return userSer.privateKey();

    }


    @Override
    public UserBO currentUser() throws SerException {
        return userSer.currentUser();
    }


    @Override
    public UserBO currentUser(String token) throws SerException {
        return userSer.currentUser(token);
    }

    @Override
    public String currentSystemNO() throws SerException {
        return userSer.currentSysNO();
    }

    @Override
    public String currentSystemNO(String token) throws SerException {
        return userSer.currentSysNO(token);
    }

    @Override
    public void add(TransactionContext context, UserTO userTO) throws SerException {
        userSer.add(context, userTO);
    }

    @Override
    public void delete(String id) throws SerException {
        userSer.delete(id);
    }
}
