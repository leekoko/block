package com.leekoko.block.entity;

/**
 * 体重枚举类
 */
public enum WeightEnum {
    STANDARD("正常体重", 1), HEAVY("体重过重", 2), LIGHT("体重过轻", 3), VERY_HEAVY("肥胖", 4), VERY_LIGHT("体重不足", 5);
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
