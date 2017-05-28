package com.bjike.reborn.commodity.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.commodity.dto.CommodityDTO;
import com.bjike.reborn.commodity.entity.Commodity;

/**
* 商品持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-20 11:23 ]
* @Description:	[ 商品持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface CommodityRep extends JpaRep<Commodity ,CommodityDTO> { 

 }