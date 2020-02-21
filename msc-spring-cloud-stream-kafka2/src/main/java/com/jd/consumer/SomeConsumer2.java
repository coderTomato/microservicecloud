package com.jd.consumer;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

//@Component
//@EnableBinding(Sink.class)
public class SomeConsumer2 {

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void printMessage(Object msg){
        System.out.println(msg);
    }
}
