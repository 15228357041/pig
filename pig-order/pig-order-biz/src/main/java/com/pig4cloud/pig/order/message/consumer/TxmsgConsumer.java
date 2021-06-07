package com.pig4cloud.pig.order.message.consumer;


import com.pig4cloud.pig.order.entity.OrderInfo;
import com.pig4cloud.pig.order.service.OrderInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;



import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 **/
@Component
@RequiredArgsConstructor
@Slf4j
@RocketMQMessageListener(consumerGroup = "consumer_group_txmsg_bank2",topic = "topic_txmsg")
public class TxmsgConsumer implements RocketMQListener<String> {

	private final OrderInfoService orderInfoService;


    //接收消息
    @Override
    public void onMessage(String message) {
		log.info("开始消费消息:{}",message);
		System.out.println(new Date());
		int a = 1/0;
		OrderInfo order = orderInfoService.getById(message);
		if (order.getOrderStatus() == 1) {
			order.setOrderStatus(2);
			orderInfoService.updateById(order);
		}
		log.info("消息消费成功");
    }
}
