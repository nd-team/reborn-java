package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.CategoryBO;
import com.bjike.reborn.commodity.dto.CategoryDTO;
import com.bjike.reborn.commodity.entity.Category;
import com.bjike.reborn.commodity.service.CategorySer;
import com.bjike.reborn.commodity.to.CategoryTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("categoryApiImpl")
public class CategoryApiImpl implements CategoryAPI {
    @Autowired
    private CategorySer categorySer;
    @Override
    public List<CategoryBO> list(CategoryDTO dto) throws SerException {
        return categorySer.list(dto);
    }

    @Override
    public void add(CategoryTO to) throws SerException  {
        categorySer.add(to);
    }

    @Override
    public void edit(CategoryTO to) throws SerException  {
        categorySer.edit(to);
    }

    @Override
    public void delete(String id) throws SerException  {
        categorySer.delete(id);
    }
}