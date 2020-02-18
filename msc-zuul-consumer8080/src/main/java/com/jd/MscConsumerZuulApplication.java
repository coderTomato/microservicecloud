package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@EnableCircuitBreaker //开启熔断器
//@SpringBootApplication
@SpringCloudApplication
public class MscConsumerZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscConsumerZuulApplication.class, args);
    }
}
