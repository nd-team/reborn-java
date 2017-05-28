package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.CommodityBO;
import com.bjike.reborn.commodity.dto.CommodityDTO;
import com.bjike.reborn.commodity.entity.Commodity;
import com.bjike.reborn.commodity.to.CommodityTO;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;

import java.util.List;

/**
 * 商品业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:23 ]
 * @Description: [ 商品业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface CommoditySer extends Ser<Commodity, CommodityDTO> {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<CommodityBO> list(CommodityDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(CommodityTO to) throws SerException  {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(CommodityTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id) throws SerException  {
    }
}