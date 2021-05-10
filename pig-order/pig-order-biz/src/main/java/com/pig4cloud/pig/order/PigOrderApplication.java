package com.pig4cloud.pig.order;

import com.pig4cloud.pig.common.security.annotation.EnablePigFeignClients;
import com.pig4cloud.pig.common.security.annotation.EnablePigResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author pig archetype
 * <p>
 * 项目启动类
 */
@EnableFeignClients
@EnablePigResourceServer
@EnableDiscoveryClient
@SpringCloudApplication
public class PigOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PigOrderApplication.class, args);
    }
}
