package com.bjike.reborn.user;

import com.bjike.reborn.user.kafka.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * 扫描com.bjike.reborn.constant.consumer 加入过滤器引入userToken
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bjike.reborn.user.action", "com.bjike.reborn.user.config", "com.bjike.reborn.common.consumer"})
@ImportResource("classpath:app.xml")
@PropertySource({"classpath:kafka.properties"})
@EnableAutoConfiguration(exclude = {ValidationAutoConfiguration.class})
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        new KafkaConsumer().consumer();
        System.in.read();
    }

}
