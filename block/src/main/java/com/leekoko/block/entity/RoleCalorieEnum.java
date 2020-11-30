package com.leekoko.block.entity;

import cn.hutool.core.util.NumberUtil;

/**
 * 角色卡路里耗能量枚举类
 * 这里假设角色的体重标准
 * 这里的耗能指的是 千卡/每千克
 */
public enum RoleCalorieEnum{


    //1卧床病人
    BED_PATIENT(25),
    //2老人
    OLD_PEOPLE(27),
    //3轻体力劳动者：75%坐/站，25%站着活动
    LIGHT_WORK(30),
    //4中体力劳动者:学生，机动车驾驶员
    MIDDLE_WORK(35),
    //5重体力劳动者：舞蹈、装卸、采矿、体育活动
    HEAVY_WORK(40);

    private Integer calorie;

    RoleCalorieEnum(Integer calorie) {
        this.calorie = calorie;
    }

    /**
     * 获取耗能
     * @return  千卡/每千克
     * 1千克 = 2公斤
     */
    public Integer getCalorie(){
        return calorie;
    }

    /**
     * 根据体重算出总耗能
     * @return  千卡/天
     */
    public Double getTotalCalorie(Integer kilogram){
        return NumberUtil.mul(calorie, kilogram).doubleValue();
    }
}
