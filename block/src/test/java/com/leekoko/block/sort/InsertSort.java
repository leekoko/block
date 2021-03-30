package com.leekoko.block.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {1, 2 , 4, 8, 0, 9, 6, 3, 5, 7};
        //插入排序调用
        sort(nums);

        System.out.print(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        int pointValue;
        for (int pointIndex = 1; pointIndex < nums.length; pointIndex++) {
            pointValue = nums[pointIndex];
            int lastPointIndex = pointIndex - 1;
            //挪空位
            while (lastPointIndex >= 0 && pointValue < nums[lastPointIndex]){
                nums[lastPointIndex + 1] = nums[lastPointIndex];
                lastPointIndex--;
            }
            nums[lastPointIndex + 1] = pointValue;
        }

    }


}
