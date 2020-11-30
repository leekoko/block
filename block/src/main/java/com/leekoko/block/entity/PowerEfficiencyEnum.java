package com.leekoko.block.entity;

import cn.hutool.core.util.NumberUtil;

/**
 * 动力效能：消化食物的过程消耗的能量
 * 这里的数值是百分比
 */
public enum PowerEfficiencyEnum {


    //1碳水化合物
    CARBOHYDRATES(0.5),
    //2蛋白质
    PROTEIN(0.3),
    //3脂类
    LIPID(0.5);

    private Double ratio;

    PowerEfficiencyEnum(Double ratio) {
        this.ratio = ratio;
    }

    /**
     * 获取比例
     * @return  百分比
     */
    public Double getRatio(){
        return ratio;
    }

    /**
     * 计算消耗食物动力效应之后，剩下的获得能量
     * @return
     */
    public Double getResidueCalorie(Double calorie){
        Double residue = 1.0 - ratio;
        return NumberUtil.mul(calorie, residue);
    }
}
