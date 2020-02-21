package com.jd.controller;

import com.jd.producer.SomeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SomeController {

    //将生产者注入
    @Autowired
    private SomeProducer producer;

    @PostMapping("/msg/send")
    public String sendHandler(@RequestParam("message") String msg){
        //生产者发消息
        return producer.sendMessage(msg);
    }
}
