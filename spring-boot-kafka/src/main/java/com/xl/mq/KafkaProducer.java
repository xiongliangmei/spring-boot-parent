package com.xl.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Component
@EnableScheduling
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    //发送消息
    @Scheduled(cron = "00/1 * * * * ?")
    public void send(){

        String message = UUID.randomUUID().toString();

        ListenableFuture future =kafkaTemplate.send("test_topic",message);

        future.addCallback(o-> System.out.println("send-消息发送成功"+message),throwable -> System.out.println("消息发送失败:"+message));
    }
}
