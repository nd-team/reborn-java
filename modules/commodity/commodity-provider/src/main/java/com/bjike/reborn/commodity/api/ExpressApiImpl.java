package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.ExpressBO;
import com.bjike.reborn.commodity.dto.ExpressDTO;
import com.bjike.reborn.commodity.service.ExpressSer;
import com.bjike.reborn.commodity.to.ExpressTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 快递业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 03:16 ]
 * @Description: [ 快递业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("expressApiImpl")
public class ExpressApiImpl implements ExpressAPI {
    @Autowired
    private ExpressSer expressSer;

    @Override
    public List<ExpressBO> list(ExpressDTO dto) throws SerException {
        return expressSer.list(dto);
    }

    @Override
    public void add(ExpressTO to) throws SerException  {
        expressSer.add(to);
    }

    @Override
    public void edit(ExpressTO to) throws SerException  {
        expressSer.edit(to);
    }

    @Override
    public void delete(String id) throws SerException  {
        expressSer.delete(id);
    }
}