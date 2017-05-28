package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.CategoryBO;
import com.bjike.reborn.commodity.dto.CategoryDTO;
import com.bjike.reborn.commodity.entity.Category;
import com.bjike.reborn.commodity.to.CategoryTO;
import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.api.UserAPI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品分类业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:08 ]
 * @Description: [ 商品分类业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class CategorySerImpl extends ServiceImpl<Category, CategoryDTO> implements CategorySer {
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<CategoryBO> list(CategoryDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        List<Category> categories = super.findByCis(dto);
        return BeanTransform.copyProperties(categories, CategoryBO.class);
    }

    @Transactional
    @Override
    public void add(CategoryTO to) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        Category category = BeanTransform.copyProperties(to, Category.class);
        category.setSystemNO(sysNO);
        if (StringUtils.isNotBlank(to.getParentId())) {
            CategoryDTO dto = new CategoryDTO();
            dto.getConditions().add(Restrict.eq(ID, to.getParentId()));
            category.setParent(super.findOne(dto));
        }
        super.save(category);

    }

    @Transactional
    @Override
    public void edit(CategoryTO to) throws SerException {
        Category category = super.findById(to.getId());
        BeanTransform.copyProperties(to, category);
        super.update(category);
    }

    @Transactional
    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}