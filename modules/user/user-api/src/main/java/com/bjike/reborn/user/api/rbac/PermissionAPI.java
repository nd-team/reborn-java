package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.PermissionAuthBO;
import com.bjike.reborn.user.bo.rbac.PermissionBO;
import com.bjike.reborn.user.to.rbac.PermissionTO;

import java.util.List;

/**
 * 对外提供权限资源业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 13:57]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface PermissionAPI {


    /**
     * 通过用户id查询其所拥有的所有权限资源
     *
     * @param userId
     * @return
     * @throws SerException
     */
    default List<PermissionAuthBO> findByUserId(String userId) throws SerException {
        return null;
    }


    /**
     * 逐层查询,逐层加载
     *
     * @param id 组id
     * @return
     */
    default List<PermissionBO> treeData(String id) throws SerException {
        return null;
    }

    /**
     * 保存权限资源
     *
     * @param permissionTO
     * @return
     * @throws SerException
     */
    default PermissionBO save(PermissionTO permissionTO) throws SerException {
        return null;
    }

    /**
     * 根据id删除权限资源
     *
     * @param id
     * @throws SerException
     */
    default void remove(String id) throws SerException {
    }

    /**
     * 更新权限资源
     * @param permissionTO
     * @throws SerException
     */
    default void update(PermissionTO permissionTO)throws SerException{

    }
    /**
     * 当前登录用户所有权限
     *
     * @return
     * @throws SerException
     */
    default List<PermissionAuthBO> currentPermissions() throws SerException {
        return null;
    }

}
