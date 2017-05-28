package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.ExpressBO;
import com.bjike.reborn.commodity.dto.ExpressDTO;
import com.bjike.reborn.commodity.to.ExpressTO;
import com.bjike.reborn.common.api.exception.SerException;

import java.util.List;

/**
 * 快递业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 03:16 ]
 * @Description: [ 快递业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface ExpressAPI {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<ExpressBO> list(ExpressDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(ExpressTO to) throws SerException  {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(ExpressTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id)  throws SerException {
    }
}