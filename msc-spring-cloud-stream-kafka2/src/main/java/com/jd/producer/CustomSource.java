package com.jd.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lijun
 * 自定义管道
 */
public interface CustomSource {

    String CHANNEL_NAME = "ootput";

    @Output(CustomSource.CHANNEL_NAME)
    MessageChannel output();
}
