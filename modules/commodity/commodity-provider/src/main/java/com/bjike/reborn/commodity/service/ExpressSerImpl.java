package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.ExpressBO;
import com.bjike.reborn.commodity.dto.ExpressDTO;
import com.bjike.reborn.commodity.entity.Express;
import com.bjike.reborn.commodity.to.ExpressTO;
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
 * 快递业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 03:16 ]
 * @Description: [ 快递业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "commoditySerCache")
@Service
public class ExpressSerImpl extends ServiceImpl<Express, ExpressDTO> implements ExpressSer {
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<ExpressBO> list(ExpressDTO dto) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        List<Express> expresses = super.findByCis(dto);
        return BeanTransform.copyProperties(expresses, ExpressBO.class);
    }

    @Transactional
    @Override
    public void add(ExpressTO to) throws SerException {
        String sysNO = userAPI.currentSystemNO();
        ExpressDTO dto = new ExpressDTO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        int seq = super.count(dto).intValue();
        Express express = BeanTransform.copyProperties(to, Express.class);
        express.setSystemNO(sysNO);
        express.setSeq(seq);
        super.save(express);
    }

    @Transactional
    @Override
    public void edit(ExpressTO to) throws SerException {
        Express express = super.findById(to.getId());
        BeanTransform.copyProperties(to, express);
        super.update(express);
    }

    @Transactional
    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}