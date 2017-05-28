package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserDetailBO;
import com.bjike.reborn.user.dto.UserDetailDTO;
import com.bjike.reborn.user.to.UserDetailTO;
import com.bjike.reborn.user.to.UserTO;

import java.util.List;

/**
 * 对外提供用户详情接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 15:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserDetailAPI {
    /**
     * 通过用户id查找用户详情
     *
     * @param userId
     * @return
     * @throws SerException
     */
    default UserDetailBO findByUserId(String userId) throws SerException {
        return null;
    }

    /**
     * 编辑
     *
     * @param userTO
     * @return
     * @throws SerException
     */
    default void update(UserTO userTO) throws SerException {

    }

    /**
     * 查询所有员工
     *
     * @return
     * @throws SerException
     */
    default List<UserDetailBO> employees(UserDetailDTO detailDTO) throws SerException {
        return null;
    }

    /**
     * 查询所有员工
     *
     * @return
     * @throws SerException
     */
    default Long employeesCount(UserDetailDTO detailDTO) throws SerException {
        return null;
    }

    /**
     * 导出员工
     * @param detailDTO
     * @return
     * @throws SerException
     */
    default byte[] export(UserDetailDTO detailDTO) throws SerException {
        return null;
    }

}
