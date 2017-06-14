package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.bo.OperateLogBO;
import com.bjike.reborn.user.dto.OperateLogDTO;
import com.bjike.reborn.user.entity.OperateLog;
import com.bjike.reborn.user.to.OperateLogTO;

import java.util.List;

/**
 * 操作日志业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 03:29 ]
 * @Description: [ 操作日志业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface OperateLogSer extends Ser<OperateLog, OperateLogDTO> {
    /**
     * 添加操作日志
     *
     * @param to
     * @return
     * @throws SerException
     */
    default void add(OperateLogTO to) throws SerException {
    }

    /**
     * 用户操作日志
     *
     * @param dto
     * @return
     * @throws SerException
     */
    default List<OperateLogBO> operates(OperateLogDTO dto) throws SerException {
        return null;
    }

    /**
     * 删除操作日志
     *
     * @param id
     * @return
     * @throws SerException
     */
    default void delete(String id) throws SerException {
    }


}