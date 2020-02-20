package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MscProviderConfigBusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscProviderConfigBusApplication.class, args);
    }
}
