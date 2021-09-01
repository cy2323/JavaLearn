package com.aoki.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author Cao Yong
 * @Date 2021-04-23
 */
public class ThreadPoolExecutorTest {

    /**
     * POOL_NUM:线程池数量
     */
    private static int POOL_NUM = 10;

    public static void main(String[] args) throws Exception {

        for(int i = 0; i < POOL_NUM; i++)
        {
            RunnableThread thread = new RunnableThread();
            FutureTask<String> task =  new FutureTask<>(thread);

            Thread t = new Thread(task);

            t.start();

            System.out.println("=========="+task.get()+"&&&&&");

        }
    }
}

class RunnableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        String str = "通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ";
        return str;
    }
}
