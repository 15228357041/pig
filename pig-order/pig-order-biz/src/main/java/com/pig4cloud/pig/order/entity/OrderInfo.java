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

package com.pig4cloud.pig.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 订单表
 *
 * @author zxf
 * @date 2021-05-01 15:12:51
 */
@Data
@TableName("order_info")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "订单表")
public class OrderInfo extends Model<OrderInfo> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private String id;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createDate;
    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateDate;
    /**
     * 是否删除   0否 1是
     */
    @ApiModelProperty(value="是否删除   0否 1是")
    private Integer isDel;
    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private String userId;
    /**
     * 订单状态  1:未支付  2:已支付  3:已到店/排队中  4:施工中 5:完工  6:已确认服务/已确认收货 7:未支付到时取消，8：已退款， 9-关闭
     */
    @ApiModelProperty(value="订单状态  1:未支付  2:已支付  3:已到店/排队中  4:施工中 5:完工  6:已确认服务/已确认收货 7:未支付到时取消，8：已退款， 9-关闭")
    private Integer orderStatus;
    /**
     * 订单号
     */
    @ApiModelProperty(value="订单号")
    private String orderNo;
    /**
     * 订单金额
     */
    @ApiModelProperty(value="订单金额")
    private String orderAmount;
    /**
     * 实际支付金额
     */
    @ApiModelProperty(value="实际支付金额")
    private String payAmount;
    /**
     * 支付时间
     */
    @ApiModelProperty(value="支付时间")
    private LocalDateTime payTime;
    }
