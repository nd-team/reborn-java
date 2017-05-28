package com.bjike.reborn.commodity.to;

import com.bjike.reborn.commodity.entity.Category;
import com.bjike.reborn.common.api.to.BaseTO;

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
public class CommodityTO extends BaseTO {


    /**
     * 商品名
     */
    private String name;

    /**
     * 所属分类
     */
    private Category category;

    /**
     * 货品编号
     */
    private String serialNumber;

    /**
     * 批发价
     */
    private Double tradePrice;

    /**
     * 会员价
     */
    private Double vipPrice;

    /**
     * 活动价
     */
    private Double activePrice;

    /**
     * 同行价
     */
    private Double colleaguePrice;

    /**
     * 零售价
     */
    private Double retailPrice;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 积分
     */
    private Double integral;

    /**
     * 上架时间
     */
    private LocalDateTime shelvesTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 别名
     */
    private String alias;



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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
}