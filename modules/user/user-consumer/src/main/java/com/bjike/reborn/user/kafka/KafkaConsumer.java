package com.bjike.reborn.user.kafka;

import com.alibaba.fastjson.JSON;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.api.OperateLogAPI;
import com.bjike.reborn.user.api.UserAPI;
import com.bjike.reborn.user.bo.OperateLogBO;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.entity.OperateLog;
import com.bjike.reborn.user.entity.User;
import com.bjike.reborn.user.service.OperateLogSer;
import com.bjike.reborn.user.service.UserSer;
import com.bjike.reborn.user.to.OperateLogTO;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-15 11:18]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    public static Environment env;
    public static OperateLogAPI operateLogAPI;

    public void consumer() {
        Properties props = new Properties();
        //zookeeper 配置
        props.put("zookeeper.connect", env.getProperty("zookeeper.connect"));
        //group 代表一个消费组
        props.put("group.id", env.getProperty("group.id"));

        //zk连接超时
        props.put("zookeeper.session.timeout.ms", env.getProperty("zookeeper.session.timeout.ms"));
        props.put("zookeeper.sync.time.ms", env.getProperty("zookeeper.sync.time.ms"));
        //自动提交偏移量时间
        props.put("auto.commit.interval.ms", env.getProperty("auto.commit.interval.ms"));
        props.put("auto.offset.reset", env.getProperty("auto.offset.reset"));
        //序列化类
        props.put("serializer.class", env.getProperty("serializer.class"));

        ConsumerConfig config = new ConsumerConfig(props);

        ConsumerConnector consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put("loggers", new Integer(1));

        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

        Map<String, List<KafkaStream<String, String>>> consumerMap =
                consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get("loggers").get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext()) {
            String msg = new String(it.next().message());
            OperateLogTO logTO = JSON.parseObject(msg, OperateLogTO.class);
            try {
                operateLogAPI.add(logTO);
            }catch (SerException e){
                e.printStackTrace();
            }

        }

    }

}
