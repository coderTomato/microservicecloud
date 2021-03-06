package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //开启feign客户端
@SpringCloudApplication
@EnableHystrixDashboard //开启Hystrix仪表盘功能
public class MscConsumerfallbackfactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscConsumerfallbackfactoryApplication.class, args);
    }
}
