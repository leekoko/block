package com.leekoko.block.mqTest;

import cn.hutool.json.JSONUtil;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * MessageModel：集群模式；广播模式
 * ConsumeMode：顺序消费；无序消费
 */
@Component
@RocketMQMessageListener(topic = "springboot-topic",consumerGroup = "consumer-group",
        messageModel = MessageModel.CLUSTERING, consumeMode = ConsumeMode.CONCURRENTLY)
public class MessageConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
//        FlowInfo flowInfo = JSONUtil.toBean(message, FlowInfo.class);
        System.out.println("----------接收到rocketmq消息:" + message);
        // rocketmq会自动捕获异常回滚  (官方默认会重复消费16次)
//        int a=1/0;


    }
}
