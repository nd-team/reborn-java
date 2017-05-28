package com.bjike.reborn.common.api.type;

/**
 * 简单的数据状态
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum Status {
    /**
     * 解冻
     */
    THAW(0),
    /**
     * 冻结
     */
    CONGEAL(1),
    /**
     * 删除
     */
    DELETE(2),
    ;

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
