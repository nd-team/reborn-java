package com.bjike.reborn.user.service;


import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.bo.DepartmentBO;
import com.bjike.reborn.user.dto.DepartmentDTO;
import com.bjike.reborn.user.entity.Department;
import com.bjike.reborn.user.to.DepartmentTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 部门业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-12-28 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@CacheConfig(cacheNames = "userSerCache")
@Service
public class DepartmentSerImpl extends ServiceImpl<Department, DepartmentDTO> implements DepartmentSer {

    @Autowired
    private UserSer userSer;

    @Override
    public List<DepartmentBO> treeData(String id) throws SerException {
        DepartmentDTO dto = new DepartmentDTO();
        if (StringUtils.isNotBlank(id)) {
            dto.getConditions().add(Restrict.eq("parent.id", id)); //查询该父节点下的子节点
        } else {
            dto.getConditions().add(Restrict.isNull("parent.id")); //查找根节点
        }
        dto.getConditions().add(Restrict.eq(STATUS, Status.THAW));
        dto.getConditions().add(Restrict.eq(SYS_NO, userSer.currentSysNO()));

        List<Department> departments = super.findByCis(dto);

        return BeanTransform.copyProperties(departments, DepartmentBO.class);
    }

    @Transactional
    @Override
    public void remove(String id) throws SerException {
        List<Department> children = getChild(id);
        if (null != children && children.size() > 0) {
            throw new SerException("该记录存在子节点数据,请先删除子节点!");
        }

        Department department = super.findById(id);
        Department parent = department.getParent();
        if (null != parent) {
            children = getChild(parent.getId());
            parent.setHasChild(children.size() != 0);
            super.update(parent);
        }
        super.remove(id);
    }

    @Transactional
    @Override
    public DepartmentBO save(DepartmentTO departmentTO) throws SerException {
        Department department = BeanTransform.copyProperties(departmentTO, Department.class, true);
        if (StringUtils.isNotBlank(departmentTO.getParentId())) {
            DepartmentDTO dto = new DepartmentDTO();
            dto.getConditions().add(Restrict.eq(ID, departmentTO.getParentId()));
            Department parent = findOne(dto);
            if (null != parent) {
                department.setParent(parent);
                parent.setHasChild(true); //更新父类子节点字段为true
                super.update(parent);
            }
        }
        department.setHasChild(false);
        department.setSystemNO(userSer.currentSysNO());

        super.save(department);
        return BeanTransform.copyProperties(department, DepartmentBO.class);
    }

    @Transactional
    @Override
    public void update(DepartmentTO departmentTO) throws SerException {
        Department department = super.findById(departmentTO.getId());
        Department old_parent = department.getParent();
        String parentId = departmentTO.getParentId();
        Department new_parent = null;
        if (StringUtils.isNotBlank(parentId)) {
            DepartmentDTO dto = new DepartmentDTO();
            dto.getConditions().add(Restrict.eq(ID, departmentTO.getParentId()));
            new_parent = super.findOne(dto);
        }

        //更新
        department.setModifyTime(LocalDateTime.now());
        department.setName(departmentTO.getName());
        department.setParent(new_parent);
        department.setModifyTime(LocalDateTime.now());
        super.update(department);


        if (null != new_parent) {
            new_parent.setHasChild(true);
            super.update(new_parent);
        }

        /**
         * 维护该节点与其父类是否有子节点
         */
        if (null != old_parent) { //以前有父节点,删除父节点后,检查其未更改前的父节点是否还存在子节点
            List<Department> children = getChild(old_parent.getId()); //查询以未更改前其父类的所有子节点
            old_parent.setHasChild(children.size() != 0);
            super.update(old_parent);
        }
    }

    private List<Department> getChild(String id) throws SerException {
        DepartmentDTO dto = new DepartmentDTO();
        dto.getConditions().add(Restrict.eq("parent.id", id));
        List<Department> children = findByCis(dto);
        return children;
    }

}
