package com.aoki.test.entity;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private String city;

    public Student() {
    }

    public Student(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.age > o.getAge())
            return 1;
        else if(this.age < o.getAge())
            return -1;
        return 0;
    }
}
