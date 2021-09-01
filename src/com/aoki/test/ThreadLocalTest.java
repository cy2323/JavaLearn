package com.aoki.test;

/**
 * ThreadLocal提供了get和set等访问接口和方法，这些方法为每个使用该变量的线程都存有一份独立的副本，因此get总是返回由当前执行线程在调用set时设置的最新值
 * @Author Cao Yong
 * @Date 2021-04-23
 */
public class ThreadLocalTest{

    private static int CNT_NUMS = 50;

    public static void main(String[] args) {
        for(int i = 0;i < CNT_NUMS ;i++){
            MyThread2 myThread = new MyThread2("Thread"+i);
            new Thread(myThread).start();
        }
    }
}

class MyThread2 implements Runnable{
    private static ThreadLocal<Integer> tls = new ThreadLocal<>();
    private int count = 0;

    private String name;
    public MyThread2(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            tls.set(count++);
            System.out.println(this.name+"-----> "+i+" ,value = "+tls.get());
        }
    }
}