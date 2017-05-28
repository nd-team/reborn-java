package com.bjike.reborn.order.service;

import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.order.dto.OrderDTO;
import com.bjike.reborn.order.entity.Order;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
* 订单业务实现
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-22 04:56 ]
* @Description:	[ 订单业务实现 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
@CacheConfig(cacheNames ="orderSerCache")
@Service
public class OrderSerImpl extends ServiceImpl<Order, OrderDTO> implements OrderSer { 

 }