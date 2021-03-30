package com.leekoko.block.rabbitMq.t1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author bennyrhys
 * @Date 12/21/20 4:37 PM
 */
public class Send {



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
        //发布消息
        String message = "Hello World 2";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println("发送了消息" + message);
        //关闭连接
        channel.close();
        connection.close();
    }
}
