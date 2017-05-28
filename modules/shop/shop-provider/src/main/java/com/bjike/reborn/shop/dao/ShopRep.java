package com.bjike.reborn.shop.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.shop.dto.ShopDTO;
import com.bjike.reborn.shop.entity.Shop;

/**
* 店铺持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-23 10:37 ]
* @Description:	[ 店铺持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface ShopRep extends JpaRep<Shop ,ShopDTO> { 

 }