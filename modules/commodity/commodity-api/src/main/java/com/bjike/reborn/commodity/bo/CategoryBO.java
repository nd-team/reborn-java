package com.bjike.reborn.commodity.bo;

import com.bjike.reborn.commodity.entity.Category;
import com.bjike.reborn.common.api.bo.BaseBO;

/**
 * 商品分类业务传输对象
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类业务传输对象 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class CategoryBO extends BaseBO {
    /**
     * 系统编号
     */
    private String systemNO;
    /**
     * 分类名
     */
    private String name;

    /**
     * 父节点
     */
    private Category parent;


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

    public String getSystemNO() {
        return systemNO;
    }

    public void setSystemNO(String systemNO) {
        this.systemNO = systemNO;
    }
}