package com.bjike.reborn.order.enums;

/**
 * 订单状态
 * @Author: [liguiqin]
 * @Date: [2017-05-22 14:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum AuditStatus {
    /**
     * 未付款
     */
    UNPAID(0),
    /**
     * 待审核
     */
    AUDIT(1),
    /**
     * 待处理
     */
    PENDING(2),
    /**
     * 已处理
     */

    PROCESSED(3),
    /**
     * 待打单(有货)
     */
    PRINTBILLS(4),
    /**
     * 交付运输
     */
    PAYTRANSPROT(7),
    /**
     * 退款
     */
    REFUND(8),
    /**
     * 忽略
     */
    IGNORE(9),
    /**
     * 完成
     */
    FINISH(10);

    private int code;

    AuditStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
