package com.leekoko.block.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class BusinessMessageReceiver {

    @Test
    public void getConnectTest() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
// "guest"/"guest" by default, limited to localhost connections
        factory.setUsername("eda");
        factory.setPassword("123456");
        factory.setVirtualHost("/");
        factory.setHost("192.168.0.24");
        factory.setPort(5672);

        Connection conn = factory.newConnection();

        Channel channel = conn.createChannel();
        String exchangeName = "LEEKOKO_EXCHANGE_NAME";
        String routingKey = "LEEKOKO_ROUTING_KEY";
        channel.exchangeDeclare(exchangeName, "direct", true);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, exchangeName, routingKey);

        conn.close();

    }

}
