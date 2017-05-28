package com.bjike.reborn.warehouse.service;

import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.api.UserAPI;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.warehouse.bo.WarehouseBO;
import com.bjike.reborn.warehouse.dto.WarehouseDTO;
import com.bjike.reborn.warehouse.entity.Warehouse;
import com.bjike.reborn.warehouse.enums.WarehouseType;
import com.bjike.reborn.warehouse.to.WarehouseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 仓库业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 02:10 ]
 * @Description: [ 仓库业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class WarehouseSerImpl extends ServiceImpl<Warehouse, WarehouseDTO> implements WarehouseSer {
    @Autowired
    private UserAPI userAPI;
    @Override
    public List<WarehouseBO> list(WarehouseDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO,sysNO));
        List<Warehouse> warehouses = super.findByCis(dto);
        return BeanTransform.copyProperties(warehouses, WarehouseBO.class);
    }

    @Transactional
    @Override
    public void add(WarehouseTO to) throws SerException {
        Warehouse warehouse = BeanTransform.copyProperties(to, Warehouse.class);
        String sysNO =userAPI.currentSystemNO();
        WarehouseDTO dto = new WarehouseDTO();
        dto.getConditions().add(Restrict.eq(SYS_NO,sysNO));
        int seq = super.count(dto).intValue();
        warehouse.setSystemNO(sysNO);
        warehouse.setSeq(seq);
        super.save(warehouse);
    }

    @Override
    public void edit(WarehouseTO to) throws SerException {
        Warehouse warehouse = super.findById(to.getId());
        BeanTransform.copyProperties(to, warehouse);
        super.update(warehouse);
    }

    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}