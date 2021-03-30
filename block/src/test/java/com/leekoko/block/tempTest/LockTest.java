package com.leekoko.block.tempTest;

import org.junit.Test;

public class LockTest {

    @Test
    public void Test(){
        LockTestPOJO lockTest = new LockTestPOJO();
        new Thread(() ->lockTest.compare()).start();
        new Thread(() ->lockTest.add()).start();
    }
}
