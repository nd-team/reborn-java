package com.bjike.reborn.commodity.to;

import com.bjike.reborn.commodity.entity.Category;
import com.bjike.reborn.common.api.to.BaseTO;

/**
 * 商品分类
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class CategoryTO extends BaseTO {

    /**
     * 分类名
     */
    private String name;

    /**
     * 父节点
     */
    private String parentId;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}