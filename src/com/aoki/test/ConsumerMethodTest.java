package com.aoki.test;

import java.util.function.Consumer;

public class ConsumerMethodTest {

    public static void main(String[] args) {

        Consumer<Integer> consumer = (x) -> {
            int num = x * 2;
            System.out.println(num);
        };

        Consumer<Integer> consumer1 = (x) -> {
            int num = x * 3;
            System.out.println(num);
        };

        Consumer<String> consumer2 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s+"hello china!");
            }
        };

        Consumer<String> consumer3 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s+"hello nanjing!");
            }
        };
        consumer.andThen(consumer1).accept(10);
        consumer1.andThen(consumer).accept(100);
        consumer.andThen(consumer).accept(1000);
        consumer2.andThen(consumer3).accept("leo");
        consumer3.andThen(consumer2).accept("jack");
        consumer2.andThen(consumer2).accept("john");

        /**
         * 输出：
         * 20
         * 30
         * 300
         * 200
         * 2000
         * 2000
         * leohello china!
         * leohello nanjing!
         * jackhello nanjing!
         * jackhello china!
         * johnhello china!
         * johnhello china!
         */
    }

}
