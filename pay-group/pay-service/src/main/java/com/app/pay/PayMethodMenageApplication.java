package com.app.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Class PayMethodMenageApplication
 * @Author zhangjie
 * @Description //TODO
 * @Date 2019/4/7 17:56
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
public class PayMethodMenageApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayMethodMenageApplication.class, args);
    }
}
