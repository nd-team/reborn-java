package com.bjike.reborn.user.bo;

import com.bjike.reborn.common.api.bo.BaseBO;

/**
 * 操作日志业务传输对象
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 03:29 ]
 * @Description: [ 操作日志业务传输对象 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class OperateLogBO extends BaseBO {

    /**
     * 模块
     */
    private String modules;


    /**
     * 操作内容
     */
    private String content;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 用户令牌
     */
    private String token;

    /**
     * 操作用户
     */
    private String username;

    private String systemNO;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }
}