package com.bjike.reborn.shop.api;

import com.bjike.reborn.shop.bo.ShopBO;
import com.bjike.reborn.shop.dto.ShopDTO;
import com.bjike.reborn.shop.service.ShopSer;
import com.bjike.reborn.shop.to.ShopTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 店铺业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 02:35 ]
 * @Description: [ 店铺业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("shopApiImpl")
public class ShopApiImpl implements ShopAPI {
    @Autowired
    private ShopSer shopSer;

    @Override
    public List<ShopBO> list(ShopDTO dto) throws SerException {
        return shopSer.list(dto);
    }

    @Override
    public void add(ShopTO to) throws SerException  {
        shopSer.add(to);
    }

    @Override
    public void edit(ShopTO to) throws SerException  {
        shopSer.edit(to);
    }

    @Override
    public void delete(String id) throws SerException  {
        shopSer.delete(id);
    }
}