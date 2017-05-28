package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.ProducingAreaBO;
import com.bjike.reborn.commodity.dto.ProducingAreaDTO;
import com.bjike.reborn.commodity.service.ProducingAreaSer;
import com.bjike.reborn.commodity.to.ProducingAreaTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产地业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 产地业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("producingAreaApiImpl")
public class ProducingAreaApiImpl implements ProducingAreaAPI {
    @Autowired
    private ProducingAreaSer producingAreaSer;

    @Override
    public List<ProducingAreaBO> list(ProducingAreaDTO dto) throws SerException {
        return producingAreaSer.list(dto);
    }

    @Override
    public void add(ProducingAreaTO to) throws SerException  {
        producingAreaSer.add(to);
    }

    @Override
    public void edit(ProducingAreaTO to) throws SerException  {
        producingAreaSer.edit(to);
    }

    @Override
    public void delete(String id) throws SerException  {
        producingAreaSer.delete(id);
    }
}