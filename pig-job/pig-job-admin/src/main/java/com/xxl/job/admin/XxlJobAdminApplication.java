package com.xxl.job.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
@EnableAutoConfiguration
public class XxlJobAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxlJobAdminApplication.class, args);
	}

}
