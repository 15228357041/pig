package com.pig4cloud.pig.demo;

import com.pig4cloud.pig.common.security.annotation.EnablePigFeignClients;
import com.pig4cloud.pig.common.security.annotation.EnablePigResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author pig archetype
 * <p>
 * 项目启动类
 */
@EnablePigFeignClients
@EnableDiscoveryClient
@EnablePigResourceServer
@SpringCloudApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
