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

package com.pig4cloud.pig.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.demo.entity.Demo;
import com.pig4cloud.pig.demo.service.DemoService;
import com.pig4cloud.pig.demo.service.ReLogService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * demo 表
 *
 * @author pig code generator
 * @date 2020-07-27 15:53:45
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/mq" )
@Api(value = "mq", tags = "rocketmq测试")
public class TestController {
	@Autowired
	RocketMQTemplate rocketMQTemplate;


    /**
     * 分页查询
     * @param jsonString 分页对象
     * @return
     */
    @GetMapping("/test" )
    public R getDemoPage(String jsonString) {
		jsonString = "消息测试";
		//生成message类型
		Message<String> message = MessageBuilder.withPayload(jsonString).build();
		//发送一条事务消息
		/**
		 * String txProducerGroup 生产组
		 * String destination topic，
		 * Message<?> message, 消息内容
		 * Object arg 参数
		 */
		rocketMQTemplate.sendMessageInTransaction("producer_group_txmsg_bank1","topic_txmsg",message,null);
		return R.ok(jsonString);
	}
}
