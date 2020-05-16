package com.leekoko.block.tools;

import org.junit.jupiter.api.Test;

class ComputeUtilsTest {

    @Test
    public void getCaloriesTest(){
        ComputeUtils.getCalories(170, 60.0, true);
        System.out.println();
        ComputeUtils.getCalories(163, 46.0, false);
    }
}