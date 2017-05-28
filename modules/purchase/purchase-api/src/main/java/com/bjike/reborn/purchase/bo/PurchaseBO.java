package com.bjike.reborn.purchase.bo;

import com.bjike.reborn.common.api.bo.BaseBO;
import com.bjike.reborn.purchase.enums.PurchaseStatus;
import com.bjike.reborn.purchase.enums.PurchaseWay;
import com.bjike.reborn.warehouse.entity.Warehouse;

import java.time.LocalDateTime;

/**
 * 采购业务传输对象
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 11:21 ]
 * @Description: [ 采购业务传输对象 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class PurchaseBO extends BaseBO {

    /**
     * 系统编号
     */
    private String systemNO;

    /**
     * 采购单号
     */
    private String purchaseNO;

    /**
     * 仓库
     */
    private Warehouse warehouse;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 数量
     */
    private String amount;

    /**
     * 单价
     */
    private Double unitPrice;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 采购价
     */
    private Double purchasePrice;

    /**
     * 其他费用
     */
    private Double otherPrice;

    /**
     * 合计
     */
    private Double total;

    /**
     * 预计到货时间
     */
    private LocalDateTime arrivalTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 运货单
     */
    private String waybillNO;

    /**
     * 采购单状态
     */
    private PurchaseStatus purchaseStatus;

    /**
     * 采购方式
     */
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