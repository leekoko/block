package com.leekoko.block.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class ChooseSort {

    public static void main(String[] args) {
        int[] insertNums = {4, 33, 10, 13, 49, 20, 8};
        //调用选择排序
        selectSort(insertNums);
        System.out.println("排序后的结果："+ Arrays.toString(insertNums));
    }

    private static void selectSort(int[] nums) {
        int index;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[index]){
                    index = j;
                }
            }
            if(index != i){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
            System.out.print("第" + i + "次排序：");
            System.out.println(Arrays.toString(nums));
        }
    }

}
