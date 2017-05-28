package com.bjike.reborn.user.session.valid_right;

import com.bjike.reborn.user.bo.rbac.PermissionAuthBO;

import java.io.Serializable;
import java.util.List;

/**
 * 登录用户
 *
 * @Author: [liguiqin]
 * @Date: [2017-04-12 08:59]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class LoginUser implements Serializable {
    /**
     * 系统编号
     */
    private String systemNO;
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;
    /**
     * 员工编号
     */
    private String employeeNumber;


    private List<PermissionAuthBO> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<PermissionAuthBO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionAuthBO> permissions) {
        this.permissions = permissions;
    }

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }
}
