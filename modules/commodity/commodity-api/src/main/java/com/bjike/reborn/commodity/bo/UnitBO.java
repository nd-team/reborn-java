package com.bjike.reborn.commodity.bo;

import com.bjike.reborn.common.api.bo.BaseBO;
import com.bjike.reborn.common.api.type.Status;

/**
 * 单位业务传输对象
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:56 ]
 * @Description: [ 单位业务传输对象 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class UnitBO extends BaseBO {
    /**
     * 系统编号
     */
    private String systemNO;

    /**
     * 单位名
     */
    private String name;

    /**
     * 状态
     */
    private Status status;

    /**
     * 排序
     */
    private Integer seq;

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}