package com.bjike.reborn.commodity.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.commodity.dto.BrandDTO;
import com.bjike.reborn.commodity.entity.Brand;

/**
* 品牌持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-20 11:55 ]
* @Description:	[ 品牌持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface BrandRep extends JpaRep<Brand ,BrandDTO> { 

 }