package com.aoki.test.algorithm;

/**
 * 冒泡排序算法
 * 原理：比较相邻的两个元素，将比较大的元素移动到右边
 * 时间复杂度：O(n的平方)
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int is[] = {19, 15, 7, 4, 3, 6, 2, 9, 8, 10, 65, 85, 47, 12, 39, 96, 100};
        int len = is.length;

        // 外层循环控制比较的范围
        for (int k = 0; k < len; k++) {
            // 内层循环控制相邻两个元素的比较和交换
            for (int j = 1; j < len - k; j++) {
                if (is[j - 1] > is[j]) {
                    int temp = is[j - 1];
                    is[j - 1] = is[j];
                    is[j] = temp;
                }
            }
        }

        for (int i : is) {
            System.out.print(i + " ");
        }

    }
}
