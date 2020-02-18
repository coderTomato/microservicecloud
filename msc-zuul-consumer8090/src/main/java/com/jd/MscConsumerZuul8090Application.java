package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@EnableCircuitBreaker //开启熔断器
//@SpringBootApplication
@SpringCloudApplication
public class MscConsumerZuul8090Application {

    public static void main(String[] args) {
        SpringApplication.run(MscConsumerZuul8090Application.class, args);
    }
}
