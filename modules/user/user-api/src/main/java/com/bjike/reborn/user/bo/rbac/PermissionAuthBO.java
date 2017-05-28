package com.bjike.reborn.user.bo.rbac;

import java.io.Serializable;

/**
 * @Author: [liguiqin]
 * @Date: [2017-05-09 09:25]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class PermissionAuthBO implements Serializable{
    /**
     * 认证资源
     */
    private String resource;
    /**
     * 是否有子节点
     */
    private Boolean hasChild;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }
}
