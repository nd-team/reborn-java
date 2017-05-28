package com.bjike.reborn.purchase.enums;

/**
 * 采购方式
 *
 * @Author: [liguiqin]
 * @Date: [2017-05-28 11:18]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum PurchaseWay {
    /**
     * 手工采购
     */
    MANUAL(0),
    /**
     * 淘宝采购
     */
    TAOBAO(1);
    private int code;

    PurchaseWay(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
