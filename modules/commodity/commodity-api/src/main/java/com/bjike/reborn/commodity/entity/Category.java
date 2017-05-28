package com.bjike.reborn.commodity.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;

import javax.persistence.*;


/**
 * 商品分类
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "commodity_category")
public class Category extends BaseEntity {

    /**
     * 系统编号
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(12)   COMMENT '系统编号'")
    private String systemNO;
    /**
     * 分类名
     */
    @Column( nullable = false, columnDefinition = "VARCHAR(50)   COMMENT '分类名'")
    private String name;

    /**
     * 父节点
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "parent_id",  columnDefinition = "VARCHAR(36) COMMENT '父节点' ")
    private Category parent;

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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}