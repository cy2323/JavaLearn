package com.aoki.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阿里巴巴面试题：：：：顺序输出“ABCABCABCABCABC”的最稳定的方法【还能改进】需要在JDK1.8下运行
 */
public class JavaTest11 {

    private static int flg = 1;
    // ReentrantLock和Condition搭配使用，注意Condition的生成方式【通过new生成】
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    private static CountDownLatch cdl1 = new CountDownLatch(1);
    private static CountDownLatch cdl2 = new CountDownLatch(1);


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            // 要使用Condition的signal和await方法之前一定要获得锁
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.print("A");

                    if(flg != 1){
                        c1.await();
                    }

                    flg = 2;
                    c2.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread1");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.print("B");

                    if(flg != 2){
                        c2.await();
                    }

                    flg = 3;
                    c3.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread2");

        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.print("C");

                    if(flg != 3){
                        c3.await();
                    }

                    flg = 1;
                    c1.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread3");


        t1.start();
        t2.start();
        t3.start();

    }
}
