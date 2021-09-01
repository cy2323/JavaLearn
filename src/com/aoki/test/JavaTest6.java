package com.aoki.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class JavaTest6 {
    public static final AtomicLong al = new AtomicLong(1L);
    public static final AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) {
        System.out.println("01.  " + al.getAndIncrement());
        System.out.println("02.  " + al.compareAndSet(2, 10));
        System.out.println("03.  " + al.get());
        System.out.println("04.  " + al.getAndDecrement());
        System.out.println("05.  " + al.get());

        ai.lazySet(1);
//        System.out.println("10.  "+);
        System.out.println("11.  " + ai.getAndIncrement());
        System.out.println("12.  " + ai.compareAndSet(2, 10));
        System.out.println("13.  " + ai.get());
        System.out.println("14.  " + ai.getAndDecrement());
        System.out.println("15.  " + ai.get());


    }
}
