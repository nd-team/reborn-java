package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.BrandBO;
import com.bjike.reborn.commodity.dto.BrandDTO;
import com.bjike.reborn.commodity.entity.Brand;
import com.bjike.reborn.commodity.to.BrandTO;
import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.api.UserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 品牌业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 品牌业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class BrandSerImpl extends ServiceImpl<Brand, BrandDTO> implements BrandSer {
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<BrandBO> list(BrandDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        return BeanTransform.copyProperties(super.findByCis(dto), BrandBO.class);
    }

    @Transactional
    @Override
    public void add(BrandTO to) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        BrandDTO dto = new BrandDTO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        int seq = super.count(dto).intValue();
        Brand brand = BeanTransform.copyProperties(to, Brand.class);
        brand.setSystemNO(sysNO);
        brand.setSeq(seq);
        super.save(brand);
    }

    @Transactional
    @Override
    public void edit(BrandTO to) throws SerException {
        Brand brand = super.findById(to.getId());
        BeanTransform.copyProperties(to, brand);
        super.update(brand);
    }

    @Transactional
    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}