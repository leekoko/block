package com.leekoko.block.entity;

import cn.hutool.core.util.NumberUtil;

/**
 * 产能营养素
 * 以下的数值为产能量： n千卡/g
 */
public enum ProductivityNutrientsEnum {


    //1碳水化合物
    CARBOHYDRATES(4),
    //2蛋白质
    PROTEIN(4),
    //3脂类
    LIPID(9);

    private Integer calorie;

    ProductivityNutrientsEnum(Integer calorie) {
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
     * 根据食物重量算出总能量
     * @return  千卡/天
     */
    public Double getTotalCalorie(Double gram){
        return NumberUtil.mul(calorie, gram).doubleValue();
    }
}
