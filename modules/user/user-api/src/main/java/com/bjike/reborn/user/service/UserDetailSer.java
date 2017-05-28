package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.bo.UserDetailBO;
import com.bjike.reborn.user.dto.UserDetailDTO;
import com.bjike.reborn.user.entity.UserDetail;
import com.bjike.reborn.user.to.UserDetailTO;
import com.bjike.reborn.user.to.UserTO;

import java.util.List;

/**
 * 部门业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-12-28 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserDetailSer extends Ser<UserDetail, UserDetailDTO> {

    default void update(UserTO userTO) throws SerException {
    }

    default UserDetailBO findByUserId(String userId) throws SerException {
        return null;
    }
    /**
     * 查询所有员工
     * @return
     * @throws SerException
     */
    default List<UserDetailBO> employees(UserDetailDTO detailDTO) throws SerException{
        return null;
    }
    /**
     * 查询所有员工
     * @return
     * @throws SerException
     */
    default Long employeesCount(UserDetailDTO detailDTO) throws SerException{
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
