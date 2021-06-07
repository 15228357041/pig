/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.pig4cloud.pig.order.controller;

import cn.hutool.json.JSONUtil;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.order.service.OrderInfoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * demo 表
 *
 * @author pig code generator
 * @date 2020-07-27 15:53:45
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order" )
@Api(value = "mq", tags = "rocketmq测试")
public class TestController {
	@Autowired
	RocketMQTemplate rocketMQTemplate;

	@Autowired
	DefaultMQProducer defaultMQProducer;


	private final OrderInfoService orderInfoService;


    /**
     * 分页查询
     * @param jsonString 分页对象
     * @return
     */
    @GetMapping("/mq/test" )
    public R getDemoPage(String jsonString) {
//		DefaultMQProducer producer = new DefaultMQProducer("producer_group_txmsg_bank1");
//// 指定RocketMQ nameServer地址
//		producer.setNamesrvAddr("localhost:9876");
//// 启动生产者
//		try {
//			producer.start();
//		} catch (MQClientException e) {
//			e.printStackTrace();
//		}
//		//messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
//		//4 指的是30s
//		Message message = new Message("topic_txmsg", jsonString.getBytes());
//		message.setDelayTimeLevel(1);
//		defaultMQProducer.setProducerGroup("producer_group_txmsg_bank1");
//		try {
//			producer.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


		jsonString = "0";
		System.out.println(new Date());

		Message<String> message = MessageBuilder.withPayload(jsonString).build();
		//发送一条事务消息
		/**
		 * String txProducerGroup 生产组
		 * String destination topic，
		 * Message<?> message, 消息内容
		 * Object arg 参数
		 */
		rocketMQTemplate.syncSend("topic_txmsg", message,  20000, 1);
		//rocketMQTemplate.sendMessageInTransaction("producer_group_txmsg_bank1","topic_txmsg",message,null);

		return R.ok(jsonString);
	}
}
