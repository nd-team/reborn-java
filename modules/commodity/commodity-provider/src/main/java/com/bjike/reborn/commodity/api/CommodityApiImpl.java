package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.CommodityBO;
import com.bjike.reborn.commodity.dto.CommodityDTO;
import com.bjike.reborn.commodity.entity.Commodity;
import com.bjike.reborn.commodity.service.CommoditySer;
import com.bjike.reborn.commodity.to.CommodityTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:23 ]
 * @Description: [ 商品业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("commodityApiImpl")
public class CommodityApiImpl implements CommodityAPI {
    @Autowired
    private CommoditySer commoditySer;
    @Override
    public List<CommodityBO> list(CommodityDTO dto) throws SerException {
        return commoditySer.list(dto);
    }

    @Override
    public void add(CommodityTO to) throws SerException  {
        commoditySer.add(to);
    }

    @Override
    public void edit(CommodityTO to) throws SerException  {
        commoditySer.edit(to);
    }

    @Override
    public void delete(String id) throws SerException  {
        commoditySer.delete(id);
    }
}