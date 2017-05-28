package com.bjike.reborn.warehouse.api;

import com.bjike.reborn.warehouse.bo.WarehouseBO;
import com.bjike.reborn.warehouse.dto.WarehouseDTO;
import com.bjike.reborn.warehouse.service.WarehouseSer;
import com.bjike.reborn.warehouse.to.WarehouseTO;
import com.bjike.reborn.common.api.exception.SerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仓库业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 02:10 ]
 * @Description: [ 仓库业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("warehouseApiImpl")
public class WarehouseApiImpl implements WarehouseAPI {
    @Autowired
    private WarehouseSer warehouseSer;

    @Override
    public List<WarehouseBO> list(WarehouseDTO dto) throws SerException {
        return warehouseSer.list(dto);
    }

    @Override
    public void add(WarehouseTO to) throws SerException  {
        warehouseSer.add(to);
    }

    @Override
    public void edit(WarehouseTO to) throws SerException  {
        warehouseSer.edit(to);
    }

    @Override
    public void delete(String id) throws SerException  {
        warehouseSer.delete(id);
    }
}