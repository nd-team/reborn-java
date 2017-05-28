package com.bjike.reborn.user.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.user.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    /**
     * 系统编号
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(12) COMMENT '系统编号'")
    protected String systemNO;

    /**
     * 用户名
     */
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50) COMMENT '用户名' ")
    private String username;

    /**
     * 登陆密码
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(255) COMMENT '用户密码'")
    private String password;

    /**
     * 用户邮箱
     */
    @Column(columnDefinition = "VARCHAR(50) COMMENT '用户名' ")
    private String email;
    /**
     * 用户类型
     */
    @Column(columnDefinition = "TINYINT(2)  COMMENT '用户类型' ", nullable = false)
    private UserType userType;

    /**
     * 用户状态
     */
    @Column(columnDefinition = "TINYINT(2) DEFAULT 0 COMMENT '用户状态'", nullable = false, insertable = false)
    private Status status;

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
