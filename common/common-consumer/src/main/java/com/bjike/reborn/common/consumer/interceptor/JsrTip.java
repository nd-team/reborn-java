package com.bjike.reborn.common.consumer.interceptor;

/**
 * 提示信息
 *
 * @Author: [huanghuanlai]
 * @Date: [2017-01-15 09:59]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class JsrTip {
    private String field;
    private String tip;

    public JsrTip(String field, String tip) {
        this.field = field;
        this.tip = tip;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
