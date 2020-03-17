package com.jd.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * @author lijun
 * @create 2020-03-17 15:14
 */
@RestController
@Slf4j
public class ConsulController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/info/consul")
    public String infoConsul(){
        return "springcloud with consul:"+serverPort+"\t "+ UUID.randomUUID().toString();
    }
}
