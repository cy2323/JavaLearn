package com.aoki.test.algorithm;

/**
 * 选择排序算法
 * 原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 时间复杂度：O(n的平方)
 */
public class SelectorSortTest {

    public static void main(String[] args) {
        int is[] = {19, 15, 7, 4, 3, 6, 2, 9, 8, 10, 65, 85, 47, 12, 39, 96, 100};
        int len = is.length;

        for (int k = 0; k < len; k++) {
            for (int i = len - 1; i > k; i--) {
                if (is[i] < is[i - 1]) {
                    int temp = is[i];
                    is[i] = is[i - 1];
                    is[i - 1] = temp;
                }
            }
        }

        for (int i : is)
            System.out.print(" " + i);
    }
}
