package com.aoki.test.entity;

import java.util.Objects;

/**
 * HashSetTest.java 测试用
 * @author CaoYong
 * @date 2021-06-07
 */
public class Person {
    private String userName;
    private int age;

    public Person(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(userName, person.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, age);
    }
}
