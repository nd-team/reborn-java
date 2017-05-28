package com.bjike.reborn.user.dao;


import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.user.dto.DepartmentDTO;
import com.bjike.reborn.user.entity.Department;

/**
 * @Author: [liguiqin]
 * @Date: [2016-12-28 15:47]
 * @Description: [部门持久化接口, 继承基类可使用ｊｐａ命名查询]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface DepartmentRep extends JpaRep<Department, DepartmentDTO> {

}
