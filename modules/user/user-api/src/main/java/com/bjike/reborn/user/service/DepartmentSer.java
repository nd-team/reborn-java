package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.bo.DepartmentBO;
import com.bjike.reborn.user.dto.DepartmentDTO;
import com.bjike.reborn.user.entity.Department;
import com.bjike.reborn.user.to.DepartmentTO;

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
public interface DepartmentSer extends Ser<Department, DepartmentDTO> {
    default List<DepartmentBO> treeData(String id) throws SerException {
        return null;
    }

    default DepartmentBO save(DepartmentTO departmentTO) throws SerException{
        return null;
    }


    default void update(DepartmentTO departmentTO)throws SerException{

    }

}
