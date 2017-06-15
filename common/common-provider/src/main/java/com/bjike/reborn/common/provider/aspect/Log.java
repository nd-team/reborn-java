package com.bjike.reborn.common.provider.aspect;

import java.io.Serializable;

/**
 * @Author: [liguiqin]
 * @Date: [2017-06-14 17:25]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class Log implements Serializable {
    /**
     * 模块
     */
    private String modules;
    /**
     * 内容
     */
    private String content;
    /**
     * 登录用户令牌
     */
    private String token;
    /**
     * 登录用户ip
     */
    private String ip;

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
}
