package com.bjike.reborn.commodity.vo;

import com.bjike.reborn.commodity.entity.Category;

/**
 * 商品分类表现层对象
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类表现层对象 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class CategoryVO {

    /**
     * id
     */
    private String id;
    /**
     * 分类名
     */
    private String name;

    /**
     * 父节点
     */
    private Category parent;



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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}