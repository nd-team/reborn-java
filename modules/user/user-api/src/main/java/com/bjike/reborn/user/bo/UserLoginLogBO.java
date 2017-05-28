package com.bjike.reborn.user.bo;

import com.bjike.reborn.common.api.bo.BaseBO;
import com.bjike.reborn.user.enums.LoginType;

/**
 * 用户登录日志业务数据传输
 *
 * @Author: [liguiqin]
 * @Date: [2017-01-21 11:16]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class UserLoginLogBO extends BaseBO {
    /**
     * 登录时间
     */
    private String loginTime;
    /**
     * 登录地点
     */
    private String loginAddress;
    /**
     * ip地址
     */
    private String loginIp;
    /**
     * 登录方式
     */
    private LoginType loginType;

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
