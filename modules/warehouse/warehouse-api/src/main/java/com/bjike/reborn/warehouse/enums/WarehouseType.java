package com.bjike.reborn.warehouse.enums;

/**
 * 仓库类型
 *
 * @Author: [liguiqin]
 * @Date: [2017-05-20 14:23]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum WarehouseType {
    /**
     * 本部仓库
     */
    LOCAL(0),
    /**
     * 残次仓
     */
    DEFECTIVE(1),
    /**
     * 委外仓
     */
    OUTSOURCING(2);

    private int code;

    WarehouseType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
