package com.leekoko.block.defignPattern;

/**
 * 构造函数构建对象
 */
public class Computer {

    private String cpu;
    private String ram;
    private int usbCount;
    private String keynoard;
    private String display;

    public Computer(String cpu, String ram){
        this(cpu, ram, 0);
    }

    public Computer(String cpu, String ram, int usbCount){
        this(cpu, ram, usbCount, "某牌键盘");
    }

    public Computer(String cpu, String ram, int usbCount, String keynoard){
        this(cpu, ram, usbCount, keynoard, "某牌显示器");
    }

    public Computer(String cpu, String ram, int usbCount, String keynoard, String display){
        this.cpu = cpu;
        this.ram = ram;
        this.usbCount = usbCount;
        this.keynoard = keynoard;
        this.display = display;
    }

}
