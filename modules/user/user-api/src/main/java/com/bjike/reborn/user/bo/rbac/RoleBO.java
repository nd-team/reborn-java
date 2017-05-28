package com.bjike.reborn.user.bo.rbac;

import com.bjike.reborn.common.api.bo.BaseBO;
import com.bjike.reborn.common.api.type.Status;

/**
 * 角色业务传输
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-01 11:38]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class RoleBO extends BaseBO {

    /**
     * 角色名
     */
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
}
