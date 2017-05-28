package com.bjike.reborn.user.bo;

import com.bjike.reborn.common.api.bo.BaseBO;
import com.bjike.reborn.common.api.type.Status;

/**
 * 用户业务传送对象
 *
 * @Author: [liguiqin]
 * @Date: [2017-01-18 15:25]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class UserBO extends BaseBO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;
    /**
     * 头像
     */
    private String systemNO;

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

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }
}
