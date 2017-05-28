package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.UnitBO;
import com.bjike.reborn.commodity.dto.UnitDTO;
import com.bjike.reborn.commodity.service.UnitSer;
import com.bjike.reborn.commodity.to.UnitTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单位业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:56 ]
 * @Description: [ 单位业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("unitApiImpl")
public class UnitApiImpl implements UnitAPI {
    @Autowired
    private UnitSer unitSer;

    @Override
    public List<UnitBO> list(UnitDTO dto) throws SerException {
        return unitSer.list(dto);
    }

    @Override
    public void add(UnitTO to) throws SerException  {
        unitSer.add(to);
    }

    @Override
    public void edit(UnitTO to) throws SerException  {
        unitSer.edit(to);
    }

    @Override
    public void delete(String id)  throws SerException {
        unitSer.delete(id);
    }
}