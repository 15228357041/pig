package com.pig4cloud.pig.demo.message.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 **/
@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "consumer_group_txmsg_bank2",topic = "topic_txmsg")
public class TxmsgConsumer implements RocketMQListener<String> {



    //接收消息
    @Override
    public void onMessage(String message) {
        log.info("开始消费消息:{}",message);
        //解析消息
		System.out.println(message);
    }
}
