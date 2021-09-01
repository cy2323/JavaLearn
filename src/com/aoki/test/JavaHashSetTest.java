package com.aoki.test;

import com.aoki.test.entity.Student;

import java.util.HashSet;
import java.util.Iterator;

public class JavaHashSetTest {

    public static void main(String[] args) {
        HashSet<Student> hSet = new HashSet<>();

        hSet.add(new Student("平手友梨奈",23,"东京"));
        hSet.add(new Student("中条彩未",25,"大阪"));
        hSet.add(new Student("曹勇",32,"南京"));

        hSet.add(new Student("曹勇",32,"南京"));

        Iterator<Student> iterator = hSet.iterator();
        while(iterator.hasNext()){
            Student stu = iterator.next();
            System.out.println(stu.getName()+" "+stu.getAge()+" "+stu.getCity());
        }
    }
}
