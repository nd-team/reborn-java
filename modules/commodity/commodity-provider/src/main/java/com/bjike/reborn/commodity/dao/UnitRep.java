package com.bjike.reborn.commodity.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.commodity.dto.UnitDTO;
import com.bjike.reborn.commodity.entity.Unit;

/**
* 单位持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-20 11:56 ]
* @Description:	[ 单位持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface UnitRep extends JpaRep<Unit ,UnitDTO> { 

 }