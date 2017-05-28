package com.bjike.reborn.commodity.service;

import com.bjike.reborn.commodity.bo.ProducingAreaBO;
import com.bjike.reborn.commodity.dto.ProducingAreaDTO;
import com.bjike.reborn.commodity.entity.ProducingArea;
import com.bjike.reborn.commodity.to.ProducingAreaTO;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;

import java.util.List;

/**
 * 产地业务接口
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 11:55 ]
 * @Description: [ 产地业务接口 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface ProducingAreaSer extends Ser<ProducingArea, ProducingAreaDTO> {
    /**
     * 列表
     *
     * @param dto
     * @return
     */
    default List<ProducingAreaBO> list(ProducingAreaDTO dto) throws SerException {
        return null;
    }

    /**
     * 添加
     *
     * @param to
     */
    default void add(ProducingAreaTO to) throws SerException  {
    }

    /**
     * 编辑
     *
     * @param to
     */
    default void edit(ProducingAreaTO to) throws SerException  {
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(String id) throws SerException  {
    }
}