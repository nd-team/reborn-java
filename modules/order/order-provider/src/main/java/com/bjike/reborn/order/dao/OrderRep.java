package com.bjike.reborn.order.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.order.dto.OrderDTO;
import com.bjike.reborn.order.entity.Order;

/**
* 订单持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-22 04:56 ]
* @Description:	[ 订单持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface OrderRep extends JpaRep<Order ,OrderDTO> { 

 }