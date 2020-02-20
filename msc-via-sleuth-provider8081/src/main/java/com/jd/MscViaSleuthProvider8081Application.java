package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MscViaSleuthProvider8081Application {

    public static void main(String[] args) {
        SpringApplication.run(MscViaSleuthProvider8081Application.class, args);
    }
}
