package com.leekoko.block.zkLogTest;

import org.apache.zookeeper.server.LogFormatter;

public class ZookeeperLogViewTest {


    public static void main(String[] args) {
        try {
            LogFormatter.main(new String[] {"D:\\tmp\\log.18f7113"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
