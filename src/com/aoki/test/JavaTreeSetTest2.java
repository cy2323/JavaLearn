package com.aoki.test;

import com.aoki.test.entity.Person;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Comparator接口实现自定义升序降序排列
 * @author CaoYong
 * @since 2021-06-08
 */
public class JavaTreeSetTest2 {

    public static void main(String[] args) {
        TreeSet<Person> tSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i = o2.getAge() - o1.getAge();
                return Integer.compare(i,0);
            }
        });

        tSet.add(new Person("leo",23));
        tSet.add(new Person("jack",25));
        tSet.add(new Person("john",20));
        tSet.add(new Person("leo",23));

        Iterator<Person> iterator = tSet.iterator();
        while (iterator.hasNext()){
            System.out.println(" "+iterator.next());
        }
    }
}
