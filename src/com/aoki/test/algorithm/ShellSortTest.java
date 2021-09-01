package com.aoki.test.algorithm;

/**
 * 希尔排序算法
 * 原理：参照=https://www.jianshu.com/p/d730ae586cf3
 * 时间复杂度：
 * 最好情况：序列是正序排列，在这种情况下，需要进行的比较操作需（n-1）次。后移赋值操作为0次。即O(n)
 * 最坏情况：O(nlog2n)
 * 平均时间复杂度：O(nlog2n)
 */
public class ShellSortTest {
    public static void main(String[] args) {
        int is[] = {19, 15, 7, 4, 3, 6, 2, 9, 8, 10, 65, 85, 47, 12, 39, 96, 100};
        //int is[] = {19,35,6,21,92,80,10,12,39,96,100};
        int len = is.length;

        System.out.print("当前间距步进为： 0, 初始排序为：[ ");
        for (int i : is)
            System.out.print(" " + i);

        System.out.print(" ];");
        System.out.println(" ");

        // 初始比较间距步进，最后一个步进一定为1
        for (int step = len / 2; step > 0; step /= 2) {
            // 直接插入排序算法
            for (int i = step; i < len; i += step) {
                int temp = is[i];
                for (int k = i; k >= step && is[k - step] > temp; k -= step) {
                    is[k] = is[k - step];
                    is[k - step] = temp;
                }

                System.out.print("当前间距步进为： " + step + ", 当前排序为：[ ");
                for (int j : is)
                    System.out.print(" " + j);

                System.out.print(" ];");
                System.out.println(" ");

            }

//            System.out.print("当前间距步进为： "+step+", 当前排序为：[ ");
//            for(int i : is)
//                System.out.print(" "+i);
//
//            System.out.print(" ];");
//            System.out.println(" ");

        }

//        for(int i : is)
//            System.out.print(" "+ i);
    }
}
