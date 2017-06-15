package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.bo.OperateLogBO;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.dto.OperateLogDTO;
import com.bjike.reborn.user.entity.OperateLog;
import com.bjike.reborn.user.to.OperateLogTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志业务实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 03:29 ]
 * @Description: [ 操作日志业务实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@CacheConfig(cacheNames = "userSerCache")
@Service
public class OperateLogSerImpl extends ServiceImpl<OperateLog, OperateLogDTO> implements OperateLogSer {
    @Autowired UserSer userSer;
    @Override
    public void add(OperateLogTO to) throws SerException {
        OperateLog log = BeanTransform.copyProperties(to,OperateLog.class);
        UserBO bo = userSer.currentUser(to.getToken());
        log.setUser(userSer.findById(bo.getId()));
        log.setSystemNO(bo.getSystemNO());
        super.save(log);
    }

    @Override
    public List<OperateLogBO> operates(OperateLogDTO dto) throws SerException {
        List<OperateLog> operateLogs = super.findByCis(dto);
        return BeanTransform.copyProperties(operateLogs,OperateLogBO.class);
    }

    @Override
    public void delete(String id) throws SerException {
        super.remove(id);
    }
}