package com.bjike.reborn.warehouse.api;

import com.bjike.reborn.warehouse.bo.WarehouseBO;
import com.bjike.reborn.warehouse.dto.WarehouseDTO;
import com.bjike.reborn.warehouse.to.WarehouseTO;
import com.bjike.reborn.common.api.exception.SerException;

import java.util.List;

/**
 * 仓库业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 02:10 ]
 * @Description: [ 仓库业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface WarehouseAPI {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<WarehouseBO> list(WarehouseDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(WarehouseTO to)  throws SerException {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(WarehouseTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id) throws SerException  {
    }
}