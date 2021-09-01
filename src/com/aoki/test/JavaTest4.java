package com.aoki.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaTest4 {

//    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        }
//    };

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10000; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                }
            });
        }

        poolExecutor.shutdown();

        //System.out.println("sb的长度为："+sb.length());
    }
}
