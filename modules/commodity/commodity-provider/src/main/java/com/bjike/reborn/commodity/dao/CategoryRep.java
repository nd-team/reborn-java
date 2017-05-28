package com.bjike.reborn.commodity.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.commodity.dto.CategoryDTO;
import com.bjike.reborn.commodity.entity.Category;

/**
* 商品分类持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-20 11:08 ]
* @Description:	[ 商品分类持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface CategoryRep extends JpaRep<Category ,CategoryDTO> { 

 }