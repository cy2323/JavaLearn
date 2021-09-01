package com.aoki.test;

/**
 * 两个整数交换位置，不涉及第三个临时变量的方式
 * 异或操作的计算规则：
 *      0 ^ N = N
 *      N ^ N = 0
 */
public class JavaTest16 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 13;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = "+a+" ,b = "+b);
    }
}
