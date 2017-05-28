package com.bjike.reborn.commodity.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 快递
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 03:16 ]
 * @Description: [ 快递 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "commodity_express")
public class Express extends BaseEntity {

    /**
     * 系统编号
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;

    /**
     * 公司
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '公司'")
    private String company;

    /**
     * 快递名称
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '快递名称'")
    private String name;

    /**
     * 联系人
     */
    @Column(  columnDefinition = "VARCHAR(15)   COMMENT '联系人'")
    private String contacts;

    /**
     * 电话
     */
    @Column(  columnDefinition = "VARCHAR(15)   COMMENT '电话'")
    private String phone;

    /**
     * 网址
     */
    @Column( columnDefinition = "VARCHAR(50)   COMMENT '网址'")
    private String url;

    /**
     * 排序
     */
    @Column( nullable = false, columnDefinition = "TINYINT(7)   COMMENT '排序'")
    private Integer seq;

    /**
     * 备注
     */
    @Column(  columnDefinition = "VARCHAR(255)   COMMENT '备注'")
    private String remark;

    /**
     * 是否使用
     */
    @Column(name = "is_enable", nullable = false, columnDefinition = "TINYINT(1)  DEFAULT 0  COMMENT '是否使用'", insertable = false)
    private Boolean enable;


    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}