package com.bjike.reborn.purchase.enums;

/**
 * 采购单状态
 *
 * @Author: [liguiqin]
 * @Date: [2017-05-28 11:21]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum PurchaseStatus {
    /**
     * 待审核
     */
    AUDIT(0),
    /**
     * 可申请
     */
    APPLY(1),
    /**
     * 待付款
     */
    WAITPAY(2),
    /**
     * 已付款
     */
    PAYED(3),

    /**
     * 待到货
     */
    WAITARRIVAL(4),
    /**
     * 待入库
     */
    WAITSTORAGE(5),
    /**
     * 已取消
     */
    CANCEL(6),
    /**
     * 已完成
     */
    FINISH(7),;


    private int code;

    PurchaseStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
