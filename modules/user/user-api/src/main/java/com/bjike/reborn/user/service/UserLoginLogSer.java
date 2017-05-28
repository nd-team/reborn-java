package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.dto.UserLoginLogDTO;
import com.bjike.reborn.user.entity.UserLoginLog;
import com.bjike.reborn.user.bo.UserLoginLogBO;
import com.bjike.reborn.user.to.UserLoginLogTO;

import java.util.List;

/**
 * 用户登录日志接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-28 15:48]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserLoginLogSer extends Ser<UserLoginLog, UserLoginLogDTO> {
    /**
     * 保存登录日志
     * @param loginLogTO
     * @throws SerException
     */
    default void saveLoginLog(UserLoginLogTO loginLogTO) throws SerException{

    }

    /**
     * 获取用户登录日志，默认前10条（最多保存也是10条）
     *
     * @return
     */
    default List<UserLoginLogBO> findByUserId(String userId) throws SerException {
        return null;
    }

}
