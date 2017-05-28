package com.bjike.reborn.shop.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;

import javax.persistence.*;


/**
 * 店铺
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 02:35 ]
 * @Description: [ 店铺 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "shop")
public class Shop extends BaseEntity {

    /**
     * 系统编号
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;

    /**
     * 店铺名
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '店铺名'")
    private String name;

    /**
     * 仓库类型
     */
    @Column(  columnDefinition = "VARCHAR(50)   COMMENT '仓库类型'")
    private String shopType;

    /**
     * 排序
     */
    @Column( nullable = false, columnDefinition = "TINYINT(7)   COMMENT '排序'")
    private Integer seq;

    /**
     * 是否可用
     */
    @Column(name = "is_enable", nullable = false, columnDefinition = "TINYINT(1)  DEFAULT 0  COMMENT '是否可用'", insertable = false)
    private Boolean enable;

    /**
     * 备注
     */
    @Column(columnDefinition = "VARCHAR(255)   COMMENT '备注'")
    private String remark;

    /**
     * 国家
     */
    @Column( columnDefinition = "VARCHAR(50)   COMMENT '国家'")
    private String country;

    /**
     * 省
     */
    @Column(  columnDefinition = "VARCHAR(50)   COMMENT '省'")
    private String province;

    /**
     * 市
     */
    @Column( columnDefinition = "VARCHAR(50)   COMMENT '市'")
    private String city;

    /**
     * 区
     */
    @Column(  columnDefinition = "VARCHAR(50)   COMMENT '区'")
    private String county;

    /**
     * 详细地址
     */
    @Column( columnDefinition = "VARCHAR(50)   COMMENT '详细地址'")
    private String address;

    /**
     * 联系人
     */
    @Column( columnDefinition = "VARCHAR(15)   COMMENT '联系人'")
    private String contacts;

    /**
     * 邮编
     */
    @Column( columnDefinition = "VARCHAR(6)   COMMENT '邮编'")
    private String zipCode;

    /**
     * 电话
     */
    @Column( columnDefinition = "VARCHAR(15)   COMMENT '电话'")
    private String phone;

    /**
     * 邮箱
     */
    @Column(  columnDefinition = "VARCHAR(30)   COMMENT '邮箱'")
    private String email;

    /**
     * 网址
     */
    @Column(  columnDefinition = "VARCHAR(255)   COMMENT '网址'")
    private String url;


    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}