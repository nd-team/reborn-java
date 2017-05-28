package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.RoleBO;
import com.bjike.reborn.user.to.rbac.RoleTO;

import java.util.List;

/**
 * 对外提供角色业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 13:56]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface RoleAPI {

    /**
     * 逐层查询,逐层加载
     *
     * @param id
     * @return
     */
    default List<RoleBO> treeData(String id) throws SerException {
        return null;
    }

    /**
     * 保存角色
     * @param roleTO
     * @return
     * @throws SerException
     */
    default RoleBO save(RoleTO roleTO) throws SerException {
        return null;
    }
    /**
     * 根据id删除角色
     * @param id
     * @throws SerException
     */
    default void remove(String id) throws SerException {
    }
    /**
     * 更新角色资源
     * @param roleTO
     * @throws SerException
     */
    default void update(RoleTO roleTO)throws SerException{

    }
}
