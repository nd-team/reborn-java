package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.UnitBO;
import com.bjike.reborn.commodity.dto.UnitDTO;
import com.bjike.reborn.commodity.entity.Unit;
import com.bjike.reborn.commodity.to.UnitTO;
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
 * 单位业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:56 ]
 * @Description: [ 单位业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class UnitSerImpl extends ServiceImpl<Unit, UnitDTO> implements UnitSer {
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<UnitBO> list(UnitDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        List<Unit> units = super.findByCis(dto);
        return BeanTransform.copyProperties(units, UnitBO.class);
    }

    @Transactional
    @Override
    public void add(UnitTO to) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        UnitDTO dto = new UnitDTO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        int seq = super.count(dto).intValue();
        Unit unit = BeanTransform.copyProperties(to, Unit.class);
        unit.setSeq(seq);
        super.save(unit);
    }

    @Transactional
    @Override
    public void edit(UnitTO to) throws SerException {
        Unit unit = super.findById(to.getId());
        BeanTransform.copyProperties(to, unit);
        super.update(unit);
    }

    @Transactional
    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}