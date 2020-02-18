package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@EnableCircuitBreaker //开启熔断器
//@SpringBootApplication
@SpringCloudApplication
public class MscZuulConsumer8280Application {

    public static void main(String[] args) {
        SpringApplication.run(MscZuulConsumer8280Application.class, args);
    }
}
