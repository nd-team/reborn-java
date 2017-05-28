package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.bo.UserDetailBO;
import com.bjike.reborn.user.dto.UserDTO;
import com.bjike.reborn.user.dto.UserDetailDTO;
import com.bjike.reborn.user.entity.UserDetail;
import com.bjike.reborn.user.to.UserTO;
import org.mengyun.tcctransaction.api.TransactionContext;

import java.util.List;

/**
 * 对外提供用户业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 13:56]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserAPI {



    /**
     * 获取公钥
     *
     * @return
     * @throws SerException
     */
    default String publicKey() throws SerException {
        return null;
    }

    /**
     * 获取私钥
     *
     * @return
     * @throws SerException
     */
    default String privateKey() throws SerException {
        return null;
    }

    /**
     * 获取当前用户
     *
     * @return
     * @throws SerException
     */
    default UserBO currentUser() throws SerException {
        return null;
    }

    /**
     * 获取当前用户
     *
     * @param userToken 用户令牌
     * @return
     * @throws SerException
     */
    default UserBO currentUser(String userToken) throws SerException {
        return null;
    }


    /**
     * 获取当前用户系统编号
     *
     * @return
     * @throws SerException
     */
    default String currentSystemNO() throws SerException {
        return null;
    }

    /**
     * 获取当前用户系统编号
     *
     * @return
     * @throws SerException
     */
    default String currentSystemNO(String token) throws SerException {
        return null;
    }

    /**
     * 添加用户
     *
     * @param userTO
     * @return
     * @throws SerException
     */
    default void add(TransactionContext context, UserTO userTO) throws SerException {
    }


    /**
     * 删除用户
     *
     * @param id
     * @return
     * @throws SerException
     */
    default void delete(String id) throws SerException {
    }


}
