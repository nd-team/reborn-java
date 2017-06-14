package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.bo.OperateLogBO;
import com.bjike.reborn.user.dto.OperateLogDTO;
import com.bjike.reborn.user.entity.OperateLog;
import com.bjike.reborn.user.service.OperateLogSer;
import com.bjike.reborn.user.to.OperateLogTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 03:29 ]
 * @Description: [ 操作日志业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("operateLogApiImpl")
public class OperateLogApiImpl implements OperateLogAPI {
    @Autowired
    private OperateLogSer operateLogSer;
    @Override
    public void add(OperateLogTO to) throws SerException {
        operateLogSer.add(to);
    }

    @Override
    public List<OperateLogBO> operates(OperateLogDTO dto) throws SerException {
        return operateLogSer.operates(dto);
    }

    @Override
    public void delete(String id) throws SerException {
        operateLogSer.delete(id);
    }
}