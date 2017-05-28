package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.CommodityBO;
import com.bjike.reborn.commodity.dto.CommodityDTO;
import com.bjike.reborn.commodity.entity.Commodity;
import com.bjike.reborn.commodity.to.CommodityTO;
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
 * 商品业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:23 ]
 * @Description: [ 商品业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class CommoditySerImpl extends ServiceImpl<Commodity, CommodityDTO> implements CommoditySer {
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<CommodityBO> list(CommodityDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        List<Commodity> commodities = super.findByCis(dto);
        return BeanTransform.copyProperties(commodities, CommodityBO.class);
    }

    @Transactional
    @Override
    public void add(CommodityTO to) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        Commodity commodity = BeanTransform.copyProperties(to, Commodity.class);
        commodity.setSystemNO(sysNO);
        super.save(commodity);
    }

    @Transactional
    @Override
    public void edit(CommodityTO to) throws SerException {
        Commodity commodity = super.findById(to.getId());
        BeanTransform.copyProperties(to, commodity);
        super.update(commodity);

    }

    @Transactional
    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}