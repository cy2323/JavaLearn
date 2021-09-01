package com.aoki.test;

import java.util.stream.IntStream;

public class Java8StreamTest {

    public static void main(String[] args) {
        // 可以代替for循环的Java 8 Stream操作
        IntStream.range(1,10).forEach(i->{
            System.out.println(" "+i);
        });
    }
}
