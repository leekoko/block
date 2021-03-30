package com.leekoko.block.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] numArr = {1, 2 , 4, 8, 0, 9, 6, 3, 5, 7};

        sortArr(numArr);

        System.out.print(Arrays.toString(numArr));
    }

    private static void sortArr(int[] numArr) {
        //遍历每个数字，检验是否需要上浮
        for (int withoutSortNum = 1; withoutSortNum < numArr.length; withoutSortNum++) {
            Boolean exchange = floatCurrentNum(numArr, withoutSortNum);
            //如果没有上浮，说明已排好序，直接退出即可
            if(!exchange){
                break;
            }
        }

    }

    /**
     * 上浮当前数字
     * @param numArr
     * @param withoutSortNum
     * @return
     */
    private static boolean floatCurrentNum(int[] numArr, int withoutSortNum) {
        boolean exchange = false;
        for (int pointTwo = 0; pointTwo < numArr.length - withoutSortNum; pointTwo++) {
            if(numArr[pointTwo] > numArr[pointTwo+1]){
                exchangeNum(numArr, pointTwo);
                exchange = true;
            }
        }
        return exchange;
    }

    /**
     * 位置交换
     * @param numArr
     * @param seqNum
     */
    private static void exchangeNum(int[] numArr, int seqNum) {
        int tempNum = numArr[seqNum + 1];
        numArr[seqNum + 1] = numArr[seqNum];
        numArr[seqNum] = tempNum;
    }

}
