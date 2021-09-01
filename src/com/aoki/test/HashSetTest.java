package com.aoki.test;

import com.aoki.test.entity.Person;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author CaoYong
 * @date 2021-06-07
 */
public class HashSetTest {

    public static void main(String[] args) {
        HashSet<Person> hSet = new HashSet<Person>();

        Person p1 = new Person("Hirate Yurina",23);
        Person p2 = new Person("张钧甯",23);
        Person p3 = new Person("中条彩未",23);

        hSet.add(p1);
        hSet.add(p2);
        hSet.add(p3);

        /**
         *  注意：如果不重写Person的HashCode和equals方法的话，jvm会判断这两个张钧甯是不同的对象，所以此处的输出为：
         *  元素个数:4
         *  元素:[Person{userName='Hirate Yurina', age=23}, Person{userName='中条彩未', age=23}, Person{userName='张钧甯', age=23}, Person{userName='张钧甯', age=23}]
         *
         *  以上包含重复的张钧甯元素。
         *
         *  所以，如果保证set元素不重复的话，一定要重写Person的HashCode和equals方法。
         *  元素个数:3
         *  元素:[Person{userName='Hirate Yurina', age=23}, Person{userName='中条彩未', age=23}, Person{userName='张钧甯', age=23}]
         *
         */
        hSet.add(new Person("张钧甯",23));

        Iterator<Person> iterator = hSet.iterator();
        while (iterator.hasNext()){
            System.out.println("元素分别为:"+iterator.next()+" ,");
        }

        System.out.println("元素个数:"+hSet.size());
        System.out.println("元素:"+hSet.toString());
    }

}