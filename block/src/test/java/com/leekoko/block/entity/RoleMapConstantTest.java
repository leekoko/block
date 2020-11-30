package com.leekoko.block.entity;

import org.junit.jupiter.api.Test;

class RoleMapConstantTest {

    /**
     * 枚举使用测试
     */
    @Test
    public void testEnum(){
        System.out.println(RoleCalorieEnum.LIGHT_WORK.getCalorie());
        System.out.println(RoleCalorieEnum.LIGHT_WORK.getTotalCalorie(61));

        System.out.println(ProductivityNutrientsEnum.LIPID.getCalorie());

        //换算之后的结果很接近    2346*5 kj 换算为 千卡，* 0.2389
        System.out.println(2346 * 5 * 0.2389);

        System.out.println((ProductivityNutrientsEnum.LIPID.getTotalCalorie(38.2)
                + ProductivityNutrientsEnum.PROTEIN.getTotalCalorie(16.4)
                + ProductivityNutrientsEnum.CARBOHYDRATES.getTotalCalorie(38.5)) * 5);

        System.out.println(ProductivityNutrientsEnum.PROTEIN.getTotalCalorie(16.4));
        System.out.print(PowerEfficiencyEnum.PROTEIN.getResidueCalorie(ProductivityNutrientsEnum.PROTEIN.getTotalCalorie(16.4)));
    }


}