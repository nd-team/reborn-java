package com.bjike.reborn.user.to.rbac;

import com.bjike.reborn.common.api.entity.ADD;
import com.bjike.reborn.common.api.entity.EDIT;
import com.bjike.reborn.common.api.to.BaseTO;
import com.bjike.reborn.common.api.type.Status;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 角色传输对象
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 13:59]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class RoleTO extends BaseTO {
    /**
     * 角色名
     */
    @NotBlank(message = "角色名不能为空", groups = {ADD.class, EDIT.class})
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态
     */
    private Status status;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 父id
     */
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
