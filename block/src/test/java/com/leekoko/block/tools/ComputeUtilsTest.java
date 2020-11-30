package com.leekoko.block.tools;

import org.junit.jupiter.api.Test;

class ComputeUtilsTest {

    @Test
    public void getCaloriesTest(){
        ComputeUtils.getWeightState(170, 60.0, true);
        System.out.println();
//        ComputeUtils.getWeightState(163, 51.0, false);
        ComputeUtils.getWeightState(155, 47.0, false);
    }
}