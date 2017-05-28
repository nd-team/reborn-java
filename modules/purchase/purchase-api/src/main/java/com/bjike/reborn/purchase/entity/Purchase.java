package com.bjike.reborn.purchase.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;
import com.bjike.reborn.purchase.enums.PurchaseStatus;
import com.bjike.reborn.purchase.enums.PurchaseWay;
import com.bjike.reborn.warehouse.entity.Warehouse;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * 采购
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 11:21 ]
 * @Description: [ 采购 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "purchase_purchase")
public class Purchase extends BaseEntity {

    /**
     * 系统编号
     */
    @Column(name = "systemNO", nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;

    /**
     * 采购单号
     */
    @Column(name = "purchaseNO", nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '采购单号'")
    private String purchaseNO;

    /**
     * 仓库
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "warehouse_id", columnDefinition = "VARCHAR(36) COMMENT '仓库' ")
    private Warehouse warehouse;

    /**
     * 供应商
     */
    @Column(name = "supplier", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '供应商'")
    private String supplier;

    /**
     * 数量
     */
    @Column(name = "amount", nullable = false, columnDefinition = "INT(5)   COMMENT '数量'")
    private String amount;

    /**
     * 单价
     */
    @Column(name = "unitPrice", nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '单价'")
    private Double unitPrice;

    /**
     * 总价
     */
    @Column(name = "totalPrice", nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '总价'")
    private Double totalPrice;

    /**
     * 采购价
     */
    @Column(name = "purchasePrice", nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '采购价'")
    private Double purchasePrice;

    /**
     * 其他费用
     */
    @Column(name = "otherPrice", nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '其他费用'")
    private Double otherPrice;

    /**
     * 合计
     */
    @Column(name = "total", nullable = false, columnDefinition = "DECIMAL(10,2)   COMMENT '合计'")
    private Double total;

    /**
     * 预计到货时间
     */
    @Column(name = "arrivalTime", nullable = false, columnDefinition = "DATETIME   COMMENT '预计到货时间'")
    private LocalDateTime arrivalTime;

    /**
     * 备注
     */
    @Column(name = "remark", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '备注'")
    private String remark;

    /**
     * 运货单
     */
    @Column(name = "waybillNO", nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '运货单'")
    private String waybillNO;

    /**
     * 采购单状态
     */
    @Column(columnDefinition = "TINYINT(2) COMMENT '采购单状态'", nullable = false)
    private PurchaseStatus purchaseStatus;

    /**
     * 采购方式
     */
    @Column(columnDefinition = "TINYINT(2) COMMENT '采购方式'", nullable = false)
    private PurchaseWay purchaseWay;


    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

    public String getPurchaseNO() {
        return purchaseNO;
    }

    public void setPurchaseNO(String purchaseNO) {
        this.purchaseNO = purchaseNO;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(Double otherPrice) {
        this.otherPrice = otherPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWaybillNO() {
        return waybillNO;
    }

    public void setWaybillNO(String waybillNO) {
        this.waybillNO = waybillNO;
    }

    public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public PurchaseWay getPurchaseWay() {
        return purchaseWay;
    }

    public void setPurchaseWay(PurchaseWay purchaseWay) {
        this.purchaseWay = purchaseWay;
    }
}