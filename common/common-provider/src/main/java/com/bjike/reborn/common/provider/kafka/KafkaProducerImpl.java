package com.bjike.reborn.common.provider.kafka;

import com.alibaba.fastjson.JSON;
import com.bjike.reborn.common.provider.aspect.Log;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-24 16:01]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */

public class KafkaProducerImpl implements KafkaProducer {

    @SuppressWarnings("all")
    @Override
    public void produce(Log log) {

        Properties props = new Properties();
        //此处配置的是kafka的端口
        props.put("metadata.broker.list", "localhost:9092");
        //配置value的序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //配置key的序列化类
        props.put("key.serializer.class", StringEncoder.class.getName());
        props.put("request.required.acks", "-1");

        Producer<String, String> producer = new Producer(new ProducerConfig(props));
        producer.send(new KeyedMessage("loggers", log.getIp(),JSON.toJSONString(log)));
    }


}
