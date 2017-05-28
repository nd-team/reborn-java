package com.bjike.reborn.user.dto.ext;


import com.bjike.reborn.common.api.dto.BaseDTO;

/**
 * 用户注册数据传输
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class UserRegisterDTO extends BaseDTO {

    /**
     * 注册用名
     */
    private String username;
    /**
     * 注册密码
     */
    private String password;
    /**
     * 重复密码
     */
    private String rePassword;
    /**
     * 注册手机
     */
    private String phone;
    /**
     * 手机验证码
     */
    private String phoneCode;
    /**
     * 验证码
     */
    private String authCode;

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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}
