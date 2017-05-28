package com.bjike.reborn.order.entity;

import com.bjike.reborn.order.enums.AuditStatus;
import com.bjike.reborn.order.enums.OrderType;
import com.bjike.reborn.common.api.entity.BaseEntity;
import com.bjike.reborn.shop.entity.Shop;
import com.bjike.reborn.warehouse.entity.Warehouse;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * 订单
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-22 02:49 ]
 * @Description: [ 订单 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "commodity_order")
public class Order extends BaseEntity {

    /**
     * 系统编号
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;

    /**
     * 所属店铺
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "shop_id",  columnDefinition = "VARCHAR(36) COMMENT '所属店铺' ")
    private Shop shop;

    /**
     * 所属仓库
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "warehouse_id",  columnDefinition = "VARCHAR(36) COMMENT '所属店铺' ")
    private Warehouse warehouse;

    /**
     * 业务员
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(20)   COMMENT '业务员'")
    private String salesman;

    /**
     * 订单类型
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(2)   COMMENT '订单类型'")
    private OrderType orderType;

    /**
     * 成交时间
     */
    @Column(nullable = false, columnDefinition = "DATETIME   COMMENT '成交时间'")
    private LocalDateTime turnoverTime;

    /**
     * 商品名
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(20)   COMMENT '商品名'")
    private String commodityName;

    /**
     * 规格
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(20)   COMMENT '规格'")
    private String standard;

    /**
     * 单位
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(20)   COMMENT '单位'")
    private String unit;

    /**
     * 购买数量
     */
    @Column( nullable = false, columnDefinition = "INT(10)   COMMENT '购买数量'")
    private Integer quantity;

    /**
     * 单价
     */
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '单价'")
    private Double unitPrice;

    /**
     * 优惠
     */
    @Column( nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '优惠'")
    private Double discount;

    /**
     * 总价
     */
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '总价'")
    private Double totalPrice;

    /**
     * 抵扣积分
     */
    @Column( nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '抵扣积分'")
    private Double deductibleIntegral;

    /**
     * 备注
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '备注'")
    private String remark;

    /**
     * 收货地址
     */
    @Column(
            nullable = false, columnDefinition = "VARCHAR(100)   COMMENT '收获地址'")
    private String address;

    /**
     * 审核状态
     */
    @Column(columnDefinition = "TINYINT(2) DEFAULT 0 COMMENT '审核状态'", nullable = false, insertable = false)
    private AuditStatus auditStatus;

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public LocalDateTime getTurnoverTime() {
        return turnoverTime;
    }

    public void setTurnoverTime(LocalDateTime turnoverTime) {
        this.turnoverTime = turnoverTime;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDeductibleIntegral() {
        return deductibleIntegral;
    }

    public void setDeductibleIntegral(Double deductibleIntegral) {
        this.deductibleIntegral = deductibleIntegral;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }
}