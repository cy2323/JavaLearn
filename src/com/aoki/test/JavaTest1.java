package com.aoki.test;

import java.util.HashMap;

public class JavaTest1 {


    static final int MAXIMUM_CAPACITY = 1 << 30;


    public static void main(String[] args) {
//        String str = "a,b,c,,";
//        String[] ary = str.split(",");
//
//        for (String s: ary) {
//            System.out.println(s.toString());
//        }
//
//        System.out.println(ary.length);


        HashMap<String, String> map = new HashMap<>();
        map.put("1", "123");
        map.put("1", "456");
        map.put("1", "789");
        map.put("1", "000");


        String s = map.get("1");
        System.out.println(s);

        System.out.println(tableSizeFor(297));

    }

    static final int tableSizeFor(int cap) {
        Integer n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
