package com.aoki.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类型实现CAS操作
 */
public class CasTest {

    private static AtomicInteger i = new AtomicInteger();

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for(int j = 0 ; j < 100000;j++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("#"+increment());
                }
            }).start();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("耗时："+(endTime-startTime));
    }

    /**
     * 注意以下两者的区别：
     *              i++ -> getAndIncrement()
     *              ++i -> incrementAndGet()
     * @return
     */
    static int increment(){
        //return i++;
        return i.getAndIncrement();
    }
}
