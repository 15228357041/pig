package com.pig4cloud.pig.demo.service;

/**
 * @Author:zxf
 * @Description
 * @Date: 2020/09/30 11:41
 */

import com.pig4cloud.pig.admin.api.entity.SysLog;
import com.pig4cloud.pig.admin.api.feign.factory.RemoteLogServiceFallbackFactory;
import com.pig4cloud.pig.common.core.constant.SecurityConstants;
import com.pig4cloud.pig.common.core.constant.ServiceNameConstants;
import com.pig4cloud.pig.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@FeignClient(contextId = "reLogService", value = ServiceNameConstants.UMPS_SERVICE)
public interface ReLogService {

	/**
	 * 保存日志
	 *
	 * @param sysLog 日志实体
	 * @param from   内部调用标志
	 * @return succes、false
	 */
	@PostMapping("/log")
	R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);


	@GetMapping("/user/{id}")
	R findUserByID(@PathVariable(value = "id") Integer id);

	@DeleteMapping("/user/{id}")
	R userDel(@PathVariable(value = "id") Integer id);
}
