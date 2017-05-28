package com.bjike.reborn.user.enums;


/**
 * 用户类型
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum UserType {

    /**
     * 管理员
     */
    ADMIN(0),
    /**
     * 员工
     */
    EMPLOYEE(1);

    private int code;

    UserType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
