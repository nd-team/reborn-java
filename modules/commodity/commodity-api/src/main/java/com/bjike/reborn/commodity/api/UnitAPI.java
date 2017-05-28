package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.UnitBO;
import com.bjike.reborn.commodity.dto.UnitDTO;
import com.bjike.reborn.commodity.to.UnitTO;
import com.bjike.reborn.common.api.exception.SerException;

import java.util.List;

/**
 * 单位业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:56 ]
 * @Description: [ 单位业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface UnitAPI {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<UnitBO> list(UnitDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(UnitTO to) throws SerException  {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(UnitTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id)  throws SerException {
    }
}