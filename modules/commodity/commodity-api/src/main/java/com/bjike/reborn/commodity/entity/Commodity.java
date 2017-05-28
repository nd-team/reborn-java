package com.bjike.reborn.commodity.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * 商品
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:23 ]
 * @Description: [ 商品 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "commodity")
public class Commodity extends BaseEntity {

    /**
     * 系统编号
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;

    /**
     * 商品名
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '商品名'")
    private String name;

    /**
     * 所属分类
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id", columnDefinition = "VARCHAR(36) COMMENT '所属分类' ")
    private Category category;
    /**
     * 商品单位
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "unit_id", columnDefinition = "VARCHAR(36) COMMENT '商品单位' ")
    private Unit unit;
    /**
     * 商品品牌
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "brand_id", columnDefinition = "VARCHAR(36) COMMENT '商品品牌' ")
    private Brand brand;
    /**
     * 商品产地
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "producingArea_id", columnDefinition = "VARCHAR(36) COMMENT '商品产地' ")
    private ProducingArea producingArea;

    /**
     * 货品编号
     */
    @Column(nullable = false,columnDefinition = "VARCHAR(15)   COMMENT '货品编号'")
    private String sku;

    /**
     * 批发价
     */
    @Column(columnDefinition = "DECIMAL(10,2)   COMMENT '批发价'")
    private Double tradePrice;

    /**
     * 会员价
     */
    @Column(columnDefinition = "DECIMAL(10,2)   COMMENT '会员价'")
    private Double vipPrice;

    /**
     * 活动价
     */
    @Column(columnDefinition = "DECIMAL(10,2)   COMMENT '活动价'")
    private Double activePrice;

    /**
     * 同行价
     */
    @Column(columnDefinition = "DECIMAL(10,2)   COMMENT '同行价'")
    private Double colleaguePrice;

    /**
     * 零售价
     */
    @Column(columnDefinition = "DECIMAL(10,2)   COMMENT '零售价'")
    private Double retailPrice;

    /**
     * 重量
     */
    @Column(columnDefinition = "DECIMAL(5,2)   COMMENT '重量'")
    private Double weight;

    /**
     * 积分
     */
    @Column(columnDefinition = "DECIMAL(10,2)   COMMENT '积分'")
    private Double integral;

    /**
     * 上架时间
     */
    @Column(columnDefinition = "DATETIME   COMMENT '上架时间'")
    private LocalDateTime shelvesTime;

    /**
     * 备注
     */
    @Column(columnDefinition = "VARCHAR(255)   COMMENT '备注'")
    private String remark;

    /**
     * 别名
     */
    @Column(columnDefinition = "VARCHAR(50)   COMMENT '别名'")
    private String alias;
    /**
     * 长
     */
    @Column(columnDefinition = "DECIMAL(5,2)   COMMENT '别名'")
    private Double length;
    /**
     * 宽
     */
    @Column(columnDefinition = "DECIMAL(5,2)   COMMENT '别名'")
    private Double wide;
    /**
     * 高
     */
    @Column(columnDefinition = "DECIMAL(5,2)   COMMENT '别名'")
    private Double high;
    /**
     * 图片
     */
    @Column(columnDefinition = "VARCHAR(255)   COMMENT '图片'")
    private String picture;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProducingArea getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(ProducingArea producingArea) {
        this.producingArea = producingArea;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public Double getActivePrice() {
        return activePrice;
    }

    public void setActivePrice(Double activePrice) {
        this.activePrice = activePrice;
    }

    public Double getColleaguePrice() {
        return colleaguePrice;
    }

    public void setColleaguePrice(Double colleaguePrice) {
        this.colleaguePrice = colleaguePrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public LocalDateTime getShelvesTime() {
        return shelvesTime;
    }

    public void setShelvesTime(LocalDateTime shelvesTime) {
        this.shelvesTime = shelvesTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWide() {
        return wide;
    }

    public void setWide(Double wide) {
        this.wide = wide;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}