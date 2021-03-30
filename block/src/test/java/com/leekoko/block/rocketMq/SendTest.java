package com.leekoko.block.rocketMq;

import com.leekoko.block.mqTest.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendTest {

    @Autowired
    private MessageSender messageSender;

    @Test
    public void messageSenderTest(){
        messageSender.syncSend();
    }


}
