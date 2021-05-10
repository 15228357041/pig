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

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.order.entity.OrderInfo;
import com.pig4cloud.pig.order.feign.UserService;
import com.pig4cloud.pig.order.service.OrderInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 订单表
 *
 * @author zxf
 * @date 2021-05-01 15:12:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order" )
@Api(value = "order", tags = "订单表管理")
public class OrderInfoController {

    private final  OrderInfoService orderInfoService;

    private final UserService userService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param orderInfo 订单表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('order_orderinfo_get')" )
    public R getOrderInfoPage(Page page, OrderInfo orderInfo) {
        return R.ok(orderInfoService.page(page, Wrappers.query(orderInfo)));
    }


    /**
     * 通过id查询订单表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('order_orderinfo_get')" )
    public R getById(@PathVariable("id" ) String id) {
        return R.ok(orderInfoService.getById(id));
    }

    /**
     * 新增订单表
     * @param orderInfo 订单表
     * @return R
     */
    @ApiOperation(value = "新增订单表", notes = "新增订单表")
    @SysLog("新增订单表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('order_orderinfo_add')" )
    public R save(@RequestBody OrderInfo orderInfo) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(1);
		userDTO.setSalt("feign测试");
		userDTO.setPhone("15228357041");
		userService.updateUser(userDTO);
        return R.ok(orderInfoService.save(orderInfo));
    }

    /**
     * 修改订单表
     * @param orderInfo 订单表
     * @return R
     */
    @ApiOperation(value = "修改订单表", notes = "修改订单表")
    @SysLog("修改订单表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('order_orderinfo_edit')" )
    public R updateById(@RequestBody OrderInfo orderInfo) {
        return R.ok(orderInfoService.updateById(orderInfo));
    }

    /**
     * 通过id删除订单表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除订单表", notes = "通过id删除订单表")
    @SysLog("通过id删除订单表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('order_orderinfo_del')" )
    public R removeById(@PathVariable String id) {
        return R.ok(orderInfoService.removeById(id));
    }

}
