package com.bjike.reborn.common.provider.utils;

import com.alibaba.dubbo.rpc.RpcContext;
import com.bjike.reborn.common.provider.constant.RpcCommon;

/**
 * token 传递
 *
 * @Author: [liguiqin]
 * @Date: [2017-04-18 14:37]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class RpcTransmit {


    /**
     * 传递用户token
     */
    public static void transmitUserToken(String userToken) {
        RpcContext.getContext().setAttachment(RpcCommon.USER_TOKEN, userToken);
    }

    /**
     * 获取用户token
     *
     * @return
     */
    public static String getUserToken() {
        return RpcContext.getContext().getAttachment(RpcCommon.USER_TOKEN);
    }

    /**
     * 获取用户ip
     */
    public static String getUserIP() {
        return RpcContext.getContext().getAttachment(RpcCommon.IP);
    }

}
