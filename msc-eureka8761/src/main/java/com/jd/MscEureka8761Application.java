package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MscEureka8761Application {

    public static void main(String[] args) {
        SpringApplication.run(MscEureka8761Application.class, args);
    }

}
