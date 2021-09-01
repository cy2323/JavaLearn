package com.aoki.test.algorithm.LeetCode;

import java.util.Arrays;

/**
 * 【LeetCode 算法】【困难】
 * 4、寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *  
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * @Author leo cao
 * @Date 2021-04-11
 */
public class LeetCodeInterview0002 {

    public static void main(String[] args) {

        /**
         * num1 = {1,5,35,64,99}
         * num2 = {10,19,22,31,36,44,56,88}
         */
        int[] num1 = {5,1,99,64,35};
        int[] num2 = {10,56,88,44,31,22,19,36};

        // 获取正序数组
        Arrays.sort(num1);
        Arrays.sort(num2);

        double rtnVal = findMedianSortedArrays(num1,num2);

        System.out.println(" "+rtnVal);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1_lo = 0;
        int nums1_hi = nums1.length-1;
        int nums2_lo = 0;
        int nums2_hi = nums2.length-1;

        while(nums1_lo <= nums1_hi){
            int mid_nums1 = nums1.length / 2;
            // int cmp = nums1.
        }


        int mid_nums2 = nums2.length / 2;



        return 0;
    }
}
