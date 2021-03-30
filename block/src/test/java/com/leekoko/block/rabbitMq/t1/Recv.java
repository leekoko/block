package com.leekoko.block.rabbitMq.t1;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author bennyrhys
 * @Date 12/21/20 5:17 PM
 */
public class Recv {



    private final static String QUEUE_NAME = "helloworld";
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ地址 注意开放安全组5672 用自己创建的用户
        factory.setHost("192.168.0.24");
        factory.setUsername("eda");
        factory.setPassword("123456");
        //建立连接
        Connection connection = factory.newConnection();
        //获得信道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //接收消息
        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("收到了消息" + message);
            }
        });
    }
}
