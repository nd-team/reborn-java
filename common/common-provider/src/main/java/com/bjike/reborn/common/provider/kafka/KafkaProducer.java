package com.bjike.reborn.common.provider.kafka;


import com.bjike.reborn.common.provider.aspect.Log;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-15 11:13]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface KafkaProducer {

    default void produce(Log log) {

    }

}
