package com.leekoko.block.entity;

/**
 * 体重枚举类
 * 体重情况可以分为以下五种类别
 */
public enum WeightEnum {
    STANDARD("1正常体重", 1), HEAVY("2体重过重", 2), LIGHT("3体重过轻", 3), VERY_HEAVY("4肥胖", 4), VERY_LIGHT("5体重不足", 5);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private WeightEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (WeightEnum c : WeightEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }



}
