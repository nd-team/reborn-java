package com.bjike.reborn.user.to;

import com.bjike.reborn.common.api.entity.ADD;
import com.bjike.reborn.common.api.entity.EDIT;
import com.bjike.reborn.common.api.to.BaseTO;
import com.bjike.reborn.common.api.type.Status;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 部门业务传输
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-01 11:38]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class DepartmentTO extends BaseTO {


    /**
     * 组名
     */
    @NotBlank(message = "部门名不能为空",groups = {ADD.class, EDIT.class})
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
