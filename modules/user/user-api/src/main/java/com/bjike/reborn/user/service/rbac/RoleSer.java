package com.bjike.reborn.user.service.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.dto.rbac.RoleDTO;
import com.bjike.reborn.user.entity.rbac.Role;
import com.bjike.reborn.user.bo.rbac.RoleBO;
import com.bjike.reborn.user.to.rbac.RoleTO;

import java.util.List;

/**
 * 角色业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface RoleSer extends Ser<Role, RoleDTO> {
    /**
     * 逐层查询,逐层加载
     * @param id
     * @return
     */
    default List<RoleBO> treeData(String id)throws SerException{
        return null;
    }

    /**
     * 保存角色资源
     * @param roleTO
     * @throws SerException
     */
    default RoleBO save(RoleTO roleTO) throws SerException {
       return  null;
    }

    /**
     * 更新角色资源
     * @param roleTO
     * @throws SerException
     */
    default void update(RoleTO roleTO)throws SerException{

    }

}
