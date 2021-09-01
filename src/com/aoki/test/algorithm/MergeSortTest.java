package com.aoki.test.algorithm;

/**
 * 归并算法【分治思想，递归实现】
 * 原理：将数组对半切割，分成左边数组和右边数组，然后对左右数组继续切割，最后对两两相邻的元素进行比较排序，最终合并成一个有序的数组
 * 平均时间复杂度：O(nlogn)
 * 最佳时间复杂度：O(n)
 * 最差时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 排序方式：In-place
 * 稳定性：稳定
 * 应用场合：归并排序思路简单，速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
 */
public class MergeSortTest {

    static int is[] = {19, 15, 7, 4, 3, 6, 2, 9, 8, 10, 65, 85, 47, 12, 39, 96, 100};
    // 总共17个元素
    static int len = is.length;
    //static int is_L[],is_R[];

    public static void main(String[] args) {
        int count = 0;

        for (int c = len; c > 0; c /= 2) {
            count++;
        }

        System.out.println(count);

        sort(is, len);

    }

    public static void sort(int[] src, int lenth) {
        //
        for (int i = lenth; i > 0; i /= 2) {
            int i_temp = lenth;
            if (i != lenth)
                divmerge(src, i, i_temp);
        }
    }

    public static void divmerge(int[] src, int pos, int pos2) {
        int is_L[] = new int[pos];
        int is_R[] = new int[pos2 - pos];
        // 左右子树的
        System.arraycopy(src, 0, is_L, 0, pos);
        System.arraycopy(src, pos, is_R, 0, pos2 - pos);
        sort(is_L, pos);
        sort(is_R, pos2 - pos);
    }
}
