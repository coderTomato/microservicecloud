package com.jd.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

//@Component
//@EnableBinding(Sink.class)
public class SomeConsumer {

    @Autowired
    @Qualifier(Sink.INPUT)
    private SubscribableChannel channel;

    @PostConstruct
    public void printMessage(){
        channel.subscribe(msg->{
            System.out.println(new String((byte[])msg.getPayload()));
        });
    }
}
