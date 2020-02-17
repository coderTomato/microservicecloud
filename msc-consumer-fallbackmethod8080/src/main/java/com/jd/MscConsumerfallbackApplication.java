package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

//@EnableCircuitBreaker //开启熔断器
//@SpringBootApplication
@SpringCloudApplication
public class MscConsumerfallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscConsumerfallbackApplication.class, args);
    }
}
