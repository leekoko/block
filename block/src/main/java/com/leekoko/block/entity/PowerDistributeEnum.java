package com.leekoko.block.entity;

import cn.hutool.core.util.NumberUtil;

/**
 * 能量来源营养素分配
 * 这里的数值是百分比
 * 中国建议的比例
 */
public enum PowerDistributeEnum {


    //1碳水化合物
    CARBOHYDRATES(0.55),
    //2蛋白质
    PROTEIN(0.15),
    //3脂类
    LIPID(0.3);

    private Double ratio;

    PowerDistributeEnum(Double ratio) {
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
     * 计算指定卡路里下，需要该营养素卡路里量
     * @return
     */
    public Double getCalorie(Double calorie){
        return NumberUtil.mul(calorie, ratio);
    }
}
