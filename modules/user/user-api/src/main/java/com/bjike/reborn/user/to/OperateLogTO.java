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
     * 功能
     */
    private String function;

    /**
     * 操作内容
     */
    private String content;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 操作用户
     */
    private String userId;

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}