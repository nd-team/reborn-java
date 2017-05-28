package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.DepartmentBO;
import com.bjike.reborn.user.to.DepartmentTO;

import java.util.List;

/**
 * 对外提供部门业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 13:57]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface DepartmentAPI {

    /**
     * 逐层查询,逐层加载
     *
     * @param id 组id
     * @return
     */
    default List<DepartmentBO> treeData(String id) throws SerException {
        return null;
    }

    /**
     * 保存部门
     * @param departmentTO
     * @return
     * @throws SerException
     */
    default DepartmentBO save(DepartmentTO departmentTO) throws SerException {
        return null;
    }

    /**
     * 根据id删除组
     * @param id
     * @throws SerException
     */
    default void remove(String id) throws SerException {
    }

    /**
     * 更新部门
     * @param departmentTO
     * @throws SerException
     */
    default void update(DepartmentTO departmentTO)throws SerException{

    }
}
