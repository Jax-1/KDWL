package com.app.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,})
@EnableDiscoveryClient
@EnableFeignClients

public class PageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageServiceApplication.class, args);
    }
}
