package com.aoki.test.algorithm;

/**
 * 插入排序算法
 * 原理：假设已知数组的第一个元素已经排好序的数组元素，从后面依次取元素与前面已经排好序的数组中的各个元素比较
 * 时间复杂度：O(n的平方)
 */
public class InsertSortTest {
    public static void main(String[] args) {
        int is[] = {0, 1000, 8522, 1554, 19, 15, 7, 4, 3, 6, 2, 9, 8, 10, 65, 85, 47, 12, 39, 96, 100};
        int len = is.length;

        // 最外层循环负责取剩余未排序的元素
        for (int i = 1; i < len; i++) {
            // 内层循环负责从已排好序的数组的末尾开始比较和移动元素，使得元素放到合适的位置
            for (int j = i - 1; j >= 0 && is[j] > is[j + 1]; j--) {
                // 交换的方法一
//                int temp = is[j];
//                is[j] = is[j + 1];
//                is[j + 1] = temp;
                // 交换的方法二：不用创建临时变量的方式
                is[j] = is[j] ^ is[j + 1];
                is[j + 1] = is[j] ^ is[j + 1];
                is[j] = is[j] ^ is[j + 1];

            }
        }

        for (int i : is)
            System.out.print(" " + i);
    }
}
