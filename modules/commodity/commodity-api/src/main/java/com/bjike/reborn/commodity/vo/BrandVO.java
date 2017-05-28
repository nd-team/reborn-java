package com.bjike.reborn.commodity.vo;

import com.bjike.reborn.common.api.type.Status;

/**
 * 品牌表现层对象
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 品牌表现层对象 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class BrandVO {

    /**
     * id
     */
    private String id;
    /**
     * 品牌名
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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