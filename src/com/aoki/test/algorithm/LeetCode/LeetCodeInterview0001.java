package com.aoki.test.algorithm.LeetCode;

import java.util.*;

/**
 * 【LeetCode 算法】【简单】
 * 22、一个整型数组，给定一个数，在数组中找出两个数的和等于这个数，并打印出来，要求O(n)。（天猫）
 * 求：数组中两个数相加为 77
 * @Author leo cao
 * @Date 2021-04-11
 */
public class LeetCodeInterview0001 {

    private final static int SUM_NUM = 77;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 1.定义一个无序的数组
        int[] intList = {2,5,6,7,1,3,9,4,10,50,61,88,23,49,70,13,19,21,18,66,44,37,38,24,21,20,91,86,82,100};

        // 2.对数组进行排序
        Arrays.sort(intList);

        // 3.调用twoSum方法
        int[] arr1 = twoSum(intList,intList.length-1);
        System.out.println(intList[arr1[0]]+","+intList[arr1[1]]);
    }

    /**
     * 计算规则：
     *        1.如果前后两个数相加大于77，则前指针后移
     *        2.如果前后两个数相加小于77，则后指针前移
     *        3.否则，保存两个下表，退出循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){

        int start = 0;
        int end = target;

        int[] arr1 = new int[2];

        while (start <= end){
            int sumUp = nums[start] + nums[end];

            if (SUM_NUM == sumUp){
                arr1[0] = start;
                arr1[1] = end;
                break;
            }else if(SUM_NUM > sumUp) {
                start++;
            }else {
                end--;
            }
        }
        return arr1;
    }

}


