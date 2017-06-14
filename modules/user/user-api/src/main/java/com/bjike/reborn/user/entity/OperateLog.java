package com.bjike.reborn.user.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;

import javax.persistence.*;


/**
 * 操作日志
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 03:29 ]
 * @Description: [ 操作日志 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "operate_log")
public class OperateLog extends BaseEntity {

    /**
     * 系统编号
     */
    @Column(name = "systemNO", nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;

    /**
     * 模块
     */
    @Column(name = "modules", nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '模块'")
    private String modules;

    /**
     * 功能
     */
    @Column(name = "function", nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '功能'")
    private String function;

    /**
     * 操作内容
     */
    @Column(name = "content", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '操作内容'")
    private String content;

    /**
     * ip地址
     */
    @Column(name = "ip", nullable = false, columnDefinition = "VARCHAR(15)   COMMENT 'ip地址'")
    private String ip;

    /**
     * 操作用户
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false, unique = true, columnDefinition = "VARCHAR(36) COMMENT '所属用户' ")
    private User user;


    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}