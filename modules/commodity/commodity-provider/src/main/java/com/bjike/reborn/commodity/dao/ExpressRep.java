package com.bjike.reborn.commodity.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.commodity.dto.ExpressDTO;
import com.bjike.reborn.commodity.entity.Express;

/**
* 快递持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-20 03:16 ]
* @Description:	[ 快递持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface ExpressRep extends JpaRep<Express ,ExpressDTO> { 

 }