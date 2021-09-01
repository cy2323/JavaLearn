package com.aoki.test;

public class JavaStaticTest {

    private int i;

    /**
     * 每new一个对象就执行一次
     */
    {
        System.out.println("这是个非静态代码块");
    }

    /**
     * 类级别，只执行一次
     */
    static {
        System.out.println("这是个静态代码块");
    }

    public JavaStaticTest(){
        System.out.println("这是无参构造器");
    }

    public JavaStaticTest(int i){
        this.i = i;
        System.out.println("这是有参构造器："+i);
    }

    public static void main(String[] args) {

        JavaStaticTest javaStaticTest = new JavaStaticTest();

        JavaStaticTest javaStaticTest2 = new JavaStaticTest(10);

        // 最后才会执行Main方法的内容
        System.out.println("这是main主方法体");

    }
}
