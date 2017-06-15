package com.bjike.reborn.user.to;

import com.bjike.reborn.common.api.to.BaseTO;

/**
 * 操作日志
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 03:29 ]
 * @Description: [ 操作日志 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class OperateLogTO extends BaseTO {

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