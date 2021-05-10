package com.pig4cloud.pig.order.feign;

import com.pig4cloud.pig.admin.api.dto.UserDTO;
import com.pig4cloud.pig.common.core.constant.ServiceNameConstants;
import com.pig4cloud.pig.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @ClassName UserService
 * @Description
 * @Author zxf
 * @Date 2021/5/2 18:41
 **/
@FeignClient(ServiceNameConstants.UMPS_SERVICE)
public interface UserService {


	@PutMapping("/user")
	R updateUser(@Valid @RequestBody UserDTO userDto);

	@GetMapping("/user/{id}")
	R findUserByID(@PathVariable(value = "id") Integer id);

}
