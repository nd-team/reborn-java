package com.bjike.reborn.user.to;

import com.bjike.reborn.common.api.to.BaseTO;
import com.bjike.reborn.user.enums.LoginType;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-11 15:25]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class UserLoginTO extends BaseTO {
    private String systemNO;

    /**
     * 登陆令牌
     */
    private String token;

    /**
     * 登陆ip
     */
    private String ip;

    /**
     * 登陆账号 email，phone，username
     */
    @NotBlank(message = "帐号不能为空")
        private String account;
    /**
     * 登录密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 记住我
     */
    private boolean rememberMe;

    /**
     * 验证码
     */
    private String authCode;
    /**
     * 登录类型
     */
    private LoginType loginType;

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
