package com.jd.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
//springcloud中的source类将MQ与生产者类通过消息管道相绑定
@EnableBinding({Source.class,CustomSource.class})
public class SomeProducer {

    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel channel;

    @Autowired
    @Qualifier(CustomSource.CHANNEL_NAME)
    private MessageChannel customChannel;

    public String sendMessage(String msg){
        //通过消息管道发送消息，即将消息写入到消息管道，再通过消息管道写入到MQ
        channel.send(MessageBuilder.withPayload(msg).build());
        customChannel.send(MessageBuilder.withPayload(msg).build());
        return msg;
    }
}
