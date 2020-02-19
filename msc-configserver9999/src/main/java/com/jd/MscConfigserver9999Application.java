package com.jd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MscConfigserver9999Application {

    public static void main(String[] args) {
        SpringApplication.run(MscConfigserver9999Application.class, args);
    }

}
