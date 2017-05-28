package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.BrandBO;
import com.bjike.reborn.commodity.dto.BrandDTO;
import com.bjike.reborn.commodity.service.BrandSer;
import com.bjike.reborn.commodity.to.BrandTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品牌业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 品牌业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("brandApiImpl")
public class BrandApiImpl implements BrandAPI {
    @Autowired
    private BrandSer brandSer;

    @Override
    public List<BrandBO> list(BrandDTO dto) throws SerException {
        return brandSer.list(dto);
    }

    @Override
    public void add(BrandTO to) throws SerException {
        brandSer.add(to);
    }

    @Override
    public void edit(BrandTO to) throws SerException {
        brandSer.edit(to);
    }

    @Override
    public void delete(String id) throws SerException {
        brandSer.delete(id);
    }
}