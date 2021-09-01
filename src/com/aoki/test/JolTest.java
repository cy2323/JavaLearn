package com.aoki.test;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author Cao Yong
 * @Date 2021-04-22
 */
public class JolTest {
    static class T{
        String j = "sasdasdasdadsdasdasdadasdasd";
        boolean a = true;
//        boolean b;
//        boolean c;
//        boolean d;
//        boolean e;
        int h = 10;
        int[] list = new int[2];
    }
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        T t = new T();
        synchronized (t) {
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
        }
    }
}
