package com.jd.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lijun
 * @create 2020-03-17 13:35
 */
@RestController
public class ProController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/info/zk")
    public String infozk(){
        return "springcloud with zk:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
