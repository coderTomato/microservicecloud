package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MscProvider8082Application {

    public static void main(String[] args) {
        SpringApplication.run(MscProvider8082Application.class, args);
    }
}
