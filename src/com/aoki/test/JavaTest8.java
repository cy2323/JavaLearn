package com.aoki.test;

import java.util.HashSet;
import java.util.Set;

/**
 * 在可变对象基础上构建的不可变类
 */
public class JavaTest8 {

    private static class ThreeStooges {
        private final Set<String> stooges
                = new HashSet<String>();

        public ThreeStooges() {
            stooges.add("leo");
            stooges.add("harry");
            stooges.add("jhon");
        }

        public boolean isStooges(String name) {
            return stooges.contains(name);
        }
    }

    public static void main(String[] args) {
        ThreeStooges stooges = new ThreeStooges();

        System.out.println("0.  " + stooges.stooges.size());

        System.out.println("1.  " + stooges.isStooges("caoyong"));
    }
}


