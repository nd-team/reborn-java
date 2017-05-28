package com.bjike.reborn.commodity.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;
import com.bjike.reborn.common.api.type.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 品牌
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 品牌 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "commodity_brand")
public class Brand extends BaseEntity {
    /**
     * 系统编号
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;
    /**
     * 品牌名
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '品牌名'")
    private String name;

    /**
     * 状态
     */
    @Column(columnDefinition = "TINYINT(2) DEFAULT 0 COMMENT '状态'", nullable = false, insertable = false)
    private Status status;

    /**
     * 排序
     */
    @Column( nullable = false, columnDefinition = "TINYINT(7)   COMMENT '排序'")
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