package com.bjike.reborn.user.dao.rbac;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.user.dto.rbac.RoleDTO;
import com.bjike.reborn.user.entity.rbac.Role;

/**
 * 角色持久化接口,继承基类可使用ｊｐａ命名查询
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface RoleRep extends JpaRep<Role, RoleDTO> {

}
