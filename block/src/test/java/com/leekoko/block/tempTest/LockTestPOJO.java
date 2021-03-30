package com.leekoko.block.tempTest;

public class LockTestPOJO {



    volatile int a = 1;
    volatile int b = 1;

    public void add() {
        System.out.println("add start");
        for (int i = 0; i < 100000000; i++) {
            ++a;
            ++b;
        }
        System.out.println("add done");
    }

    public void compare() {
        System.out.println("compare start");
        for (int i = 0; i < 100000000; i++) {
            //a始终等于b吗？
            if (a < b) {
                System.out.println( a+","+ b+","+ (a < b));
                //最后的a>b应该始终是false吗？
            }
        }
        System.out.println("compare done");
    }

}
