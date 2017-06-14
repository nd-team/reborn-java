package com.bjike.reborn.user.dao;

import com.bjike.reborn.common.jpa.dao.JpaRep;
import com.bjike.reborn.user.dto.OperateLogDTO;
import com.bjike.reborn.user.entity.OperateLog;

/**
* 操作日志持久化接口, 继承基类可使用ｊｐａ命名查询
* @Author:			[ liguiqin ]
* @Date:			[  2017-05-28 03:29 ]
* @Description:	[ 操作日志持久化接口, 继承基类可使用ｊｐａ命名查询 ]
* @Version:		[ v1.0.0 ]
* @Copy:   		[ com.bjike ]
*/
public interface OperateLogRep extends JpaRep<OperateLog ,OperateLogDTO> { 

 }