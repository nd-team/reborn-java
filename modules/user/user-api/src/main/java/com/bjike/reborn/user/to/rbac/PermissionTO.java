package com.bjike.reborn.user.to.rbac;

import com.bjike.reborn.common.api.entity.ADD;
import com.bjike.reborn.common.api.entity.EDIT;
import com.bjike.reborn.common.api.to.BaseTO;
import com.bjike.reborn.common.api.type.Status;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 权限传输对象
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 14:00]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class PermissionTO extends BaseTO {
    /**
     * 权限名
     */
    @NotBlank(message = "资源名不能为空", groups = {ADD.class, EDIT.class})
    private String name;
    /**
     * 资源
     */
    @NotBlank(message = "资源不能为空", groups = {ADD.class, EDIT.class})
    private String resource;

    /**
     * 父资源
     */
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
