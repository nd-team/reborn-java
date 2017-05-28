package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.ProducingAreaBO;
import com.bjike.reborn.commodity.dto.ProducingAreaDTO;
import com.bjike.reborn.commodity.entity.ProducingArea;
import com.bjike.reborn.commodity.to.ProducingAreaTO;
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
 * 产地业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 产地业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class ProducingAreaSerImpl extends ServiceImpl<ProducingArea, ProducingAreaDTO> implements ProducingAreaSer {
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<ProducingAreaBO> list(ProducingAreaDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        List<ProducingArea> producingAreas = super.findByCis(dto);
        return BeanTransform.copyProperties(producingAreas, ProducingAreaBO.class);
    }

    @Transactional
    @Override
    public void add(ProducingAreaTO to) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        ProducingAreaDTO dto = new ProducingAreaDTO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        int seq = super.count(dto).intValue();
        ProducingArea producingArea = BeanTransform.copyProperties(to, ProducingArea.class);
        producingArea.setSystemNO(sysNO);
        producingArea.setSeq(seq);
        super.save(producingArea);
    }

    @Transactional
    @Override
    public void edit(ProducingAreaTO to) throws SerException {
        ProducingArea producingArea = super.findById(to.getId());
        BeanTransform.copyProperties(to, producingArea);
        super.update(producingArea);
    }

    @Transactional
    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}