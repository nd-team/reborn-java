package com.bjike.reborn.user.dto;


import com.bjike.reborn.common.api.dto.BaseDTO;

/**
 * 部门数据传输
 *
 * @Author: [liguiqin]
 * @Date: [2016-12-28 09:45]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class DepartmentDTO extends BaseDTO {
    /**
     * 父亲节点
     */
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
