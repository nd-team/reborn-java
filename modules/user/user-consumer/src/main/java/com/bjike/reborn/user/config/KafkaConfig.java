package com.bjike.reborn.user.config;


import com.bjike.reborn.user.api.OperateLogAPI;
import com.bjike.reborn.user.kafka.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Author: [liguiqin]
 * @Date: [2017-06-15 11:12]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Component
public class KafkaConfig {

    @Autowired
    private Environment env;
    @Autowired
    private OperateLogAPI operateLogAPI;


    @Bean
    public KafkaConfig init() {
        KafkaConsumer.env = env;
        KafkaConsumer.operateLogAPI = operateLogAPI;
        return new KafkaConfig();
    }


    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }
}
