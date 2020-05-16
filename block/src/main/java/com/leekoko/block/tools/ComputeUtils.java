package com.leekoko.block.tools;

import cn.hutool.core.util.NumberUtil;
import com.leekoko.block.entity.WeightEnum;

import java.math.BigDecimal;

/**
 * 计算工具类
 */
public class ComputeUtils {

    /**
     * 获取卡路里量
     * @param height 身高  cm
     * @param weight 体重  kg
     * @param isMan 是否为男性
     */
    public static void getCalories(Integer height, Double weight, Boolean isMan){
        Double standardWeight = 0.0;
        if(isMan){
            Integer subNum = 80;
            standardWeight = NumberUtil.sub(height, subNum).multiply(new BigDecimal(0.7)).doubleValue();
        }else{
            Integer subNum = 70;
            standardWeight = NumberUtil.sub(height, subNum).multiply(new BigDecimal(0.6)).doubleValue();
        }
        Double differenceValue = 0.0;
        Boolean isFact = true;
        if(weight > standardWeight){
            //偏胖
            isFact = true;
            differenceValue = NumberUtil.sub(weight, standardWeight);
        }if(weight < standardWeight){
            //偏瘦
            isFact = false;
            differenceValue = NumberUtil.sub(standardWeight, weight);
        }
        String msg = "";
        if(differenceValue < weight * 0.1){
            msg = WeightEnum.STANDARD.getName();
        }else if(weight * 0.1 <= differenceValue && differenceValue <= weight * 0.2){
            if(isFact){
                msg = WeightEnum.HEAVY.getName();
            }else{
                msg = WeightEnum.LIGHT.getName();
            }
        }else if(differenceValue >  weight * 0.2){
            if(isFact){
                msg = WeightEnum.VERY_HEAVY.getName();
            }else{
                msg = WeightEnum.VERY_LIGHT.getName();
            }
        }
        System.out.println("您的身高："+height+"cm;体重："+weight+"kg;属于：【"+msg+"】类型;标准的体重为："+NumberUtil.roundStr(standardWeight, 2));
    }





}
