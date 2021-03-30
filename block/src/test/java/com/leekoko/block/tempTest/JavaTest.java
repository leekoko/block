package com.leekoko.block.tempTest;

public class JavaTest {

    public static void main(String[] args) {

        new JavaTest().test("leekoko", new PersonCallBack() {
            @Override
            public void callback() {
                System.out.println("callback1");
            }
        });

        new JavaTest().test("leekoko", ()->{
            System.out.println("callback2");
        });
    }

    public void test(String name, PersonCallBack callBack){
        callBack.callback();
    }

}
