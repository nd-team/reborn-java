package com.bjike.reborn.purchase.service;

import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.purchase.dto.PurchaseDTO;
import com.bjike.reborn.purchase.entity.Purchase;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
* 采购业务实现
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-28 11:21 ]
* @Description:	[ 采购业务实现 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
@CacheConfig(cacheNames ="purchaseSerCache")
@Service
public class PurchaseSerImpl extends ServiceImpl<Purchase, PurchaseDTO> implements PurchaseSer { 

 }