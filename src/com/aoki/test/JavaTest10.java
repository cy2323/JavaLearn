package com.aoki.test;

import java.util.concurrent.ConcurrentHashMap;

public class JavaTest10 {

    public static void main(String[] args) {

        int oldCapacity = 64;

        int newCapacoty = (oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1);
        System.out.println("1.     " + newCapacoty);
        System.out.println("2.     " + Integer.MAX_VALUE + "     " + Integer.MIN_VALUE);

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("class", "four");

        /**
         * putIfAbsent:
         *          如果存在key，则返回目前key对应的value；
         *          如果不存在key，则插入给定的key和value并且返回null。
         */
        String s = map.putIfAbsent("class2", "three");
        System.out.println("3.     " + s);
    }
}
