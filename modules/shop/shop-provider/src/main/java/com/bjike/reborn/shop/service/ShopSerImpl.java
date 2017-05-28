package com.bjike.reborn.shop.service;

import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.shop.bo.ShopBO;
import com.bjike.reborn.shop.dto.ShopDTO;
import com.bjike.reborn.shop.entity.Shop;
import com.bjike.reborn.shop.to.ShopTO;
import com.bjike.reborn.user.api.UserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 店铺业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 02:35 ]
 * @Description: [ 店铺业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class ShopSerImpl extends ServiceImpl<Shop, ShopDTO> implements ShopSer {
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<ShopBO> list(ShopDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        List<Shop> shops = super.findByCis(dto);
        return BeanTransform.copyProperties(shops, ShopBO.class);
    }

    @Override
    public void add(ShopTO to) throws SerException {
        Shop shop = BeanTransform.copyProperties(to, Shop.class);
        String sysNO = userAPI.currentSystemNO();
        shop.setSystemNO(sysNO);
        ShopDTO dto = new ShopDTO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        int seq = super.count(dto).intValue();
        shop.setSeq(seq);
        super.save(shop);
    }

    @Override
    public void edit(ShopTO to) throws SerException {
        Shop shop = super.findById(to.getId());
        BeanTransform.copyProperties(to, shop);
        super.update(shop);
    }

    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}