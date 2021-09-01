package com.aoki.test;

/**
 * 类 JavaTest15 通过 A.value 引用了类 B 中声明的静态域 value。由于 value
 * 是在类 B 中声明的，只有类 B 会被初始化，而类 A 则不会被初始化。
 */
public class JavaTest15 {
    public static void main(String[] args) {
        System.out.println(A.value); //输出100
    }
}

class B {
    static int value = 100;
    static {
        System.out.println("Class B is initialized."); //输出
    }
}

class A extends B {
    static {
        System.out.println("Class A is initialized."); //不会输出
    }
}
