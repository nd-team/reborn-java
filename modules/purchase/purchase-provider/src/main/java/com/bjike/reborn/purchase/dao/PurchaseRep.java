package com.bjike.reborn.purchase.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.purchase.dto.PurchaseDTO;
import com.bjike.reborn.purchase.entity.Purchase;

/**
 * 采购持久化接口, 继承基类可使用ｊｐａ命名查询
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-28 11:21 ]
 * @Description: [ 采购持久化接口, 继承基类可使用ｊｐａ命名查询 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public interface PurchaseRep extends JpaRep<Purchase, PurchaseDTO> {

}