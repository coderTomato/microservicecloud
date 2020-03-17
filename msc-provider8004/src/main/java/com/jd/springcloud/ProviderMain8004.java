package com.jd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lijun
 * @create 2020-03-17 13:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8004.class, args);
    }
}
