package com.aoki.test;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 阿里巴巴推荐使用创建线程池的方式获取线程，本文是通过创建线程工厂的方式获取线程
 * @Author Cao Yong
 * @Date 2021-04-23
 */
public class ThreadFactoryTest {

    public static void main(String[] args) {

        UserThreadFactory userThreadFactory = new UserThreadFactory("我爱北京天安门");
        Thread thread = userThreadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈哈哈哈哈哈");
            }
        });

        // Thread.currentThread()获取的永远是主线程
        System.out.println("1. "+Thread.currentThread().getName());

        thread.start();

    }
}

/**
 * 采用线程安全的方式创建工厂类
 * 安全发布，不造成逸出
 */
class UserThreadFactory implements ThreadFactory{

    private final String namePrefix;
    /**
     * nextId : 可用原子类的方式保证变量自增操作的原子性
     */
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = ""+ whatFeatureOfGroup + "-worker-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null,r,name,0);
        System.out.println("2. "+thread.getName());
        return thread;
    }
}