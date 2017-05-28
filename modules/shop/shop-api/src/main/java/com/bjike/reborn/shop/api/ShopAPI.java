package com.bjike.reborn.shop.api;

import com.bjike.reborn.shop.bo.ShopBO;
import com.bjike.reborn.shop.dto.ShopDTO;
import com.bjike.reborn.shop.to.ShopTO;
import com.bjike.reborn.common.api.exception.SerException;

import java.util.List;

/**
 * 店铺业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 02:35 ]
 * @Description: [ 店铺业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface ShopAPI {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<ShopBO> list(ShopDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(ShopTO to) throws SerException  {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(ShopTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id) throws SerException  {
    }
}