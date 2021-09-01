package com.aoki.test;

import com.aoki.test.entity.Student;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * o2.compareTo(o1) 升序
 * o1.compareTo(o2) 降序
 * @author CaoYong
 * @since 2021-06-08
 */
public class JavaTreeSetTest {
    public static void main(String[] args) {
        TreeSet<Student> tSet = new TreeSet<>();

        tSet.add(new Student("平手友梨奈",22,"东京"));
        tSet.add(new Student("中条彩未",26,"大阪"));
        tSet.add(new Student("曹勇",31,"南京"));

        tSet.add(new Student("曹勇",31,"南京"));

        Iterator<Student> iterator = tSet.iterator();
        while(iterator.hasNext()){
            System.out.println(" "+iterator.next());
        }
    }
}
