package com.bjike.reborn.warehouse.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.warehouse.dto.WarehouseDTO;
import com.bjike.reborn.warehouse.entity.Warehouse;

/**
 * 仓库持久化接口, 继承基类可使用ｊｐａ命名查询
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-22 04:56 ]
 * @Description: [ 仓库持久化接口, 继承基类可使用ｊｐａ命名查询 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface WarehouseRep extends JpaRep<Warehouse, WarehouseDTO> {

}