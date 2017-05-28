package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.CategoryBO;
import com.bjike.reborn.commodity.dto.CategoryDTO;
import com.bjike.reborn.commodity.entity.Category;
import com.bjike.reborn.commodity.to.CategoryTO;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;

import java.util.List;

/**
 * 商品分类业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface CategorySer extends Ser<Category, CategoryDTO> {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<CategoryBO> list(CategoryDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(CategoryTO to) throws SerException  {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(CategoryTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id) throws SerException  {
    }

}