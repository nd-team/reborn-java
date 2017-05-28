package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserLoginLogBO;
import com.bjike.reborn.user.to.UserLoginLogTO;

import java.util.List;

/**
 * 对外提供登录日志业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 16:38]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserLoginLogAPI {
    /**
     * 保存登录日志
     *
     * @param loginLogTO
     * @throws SerException
     */
    default void save(UserLoginLogTO loginLogTO) throws SerException {

    }

    ;

    /**
     * 获取用户登录日志，默认前5条（最多保存也是5条）
     *
     * @return
     */
    default List<UserLoginLogBO> findByUserId(String userId) throws SerException {
        return null;
    }

}
