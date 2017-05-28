package com.bjike.reborn.commodity.api;

import com.bjike.reborn.commodity.bo.BrandBO;
import com.bjike.reborn.commodity.dto.BrandDTO;
import com.bjike.reborn.commodity.to.BrandTO;
import com.bjike.reborn.common.api.exception.SerException;

import java.util.List;

/**
 * 品牌业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 品牌业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface BrandAPI {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<BrandBO> list(BrandDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(BrandTO to) throws SerException  {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(BrandTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id) throws SerException  {
    }
}