package com.aoki.test;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class JavaTreeMapTest{

    public static void main(String[] args) {
//        TreeMap<Integer,String> tMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//
//        tMap.put(3,"john");
//        tMap.put(12,"denny");
//        tMap.put(11,"amanda");
//        tMap.put(2,"lucy");
//        tMap.put(10,"mike");
//        tMap.put(1,"leo");
//        tMap.put(11,"amanda2");
//
//        for (Map.Entry<Integer,String> entry:tMap.entrySet()) {
//            System.out.println("key: "+entry.getKey()+" ;value: "+entry.getValue());
//        }

        Dog d1 = new Dog("coco1",12);
        Dog d2 = new Dog("coco2",1);
        Dog d3 = new Dog("coco3",5);
        Dog d4 = new Dog("coco4",21);
        Dog d5 = new Dog("coco5",7);
        Dog d6 = new Dog("coco6",3);

        TreeMap<Dog,String> tMap = new TreeMap<>();
        tMap.put(d1,"1");
        tMap.put(d2,"2");
        tMap.put(d3,"3");
        tMap.put(d4,"4");
        tMap.put(d5,"5");
        tMap.put(d6,"6");

        for(Map.Entry<Dog, String> entry: tMap.entrySet())
        {
            System.out.println("The treemap key is: "+entry.getKey()+" ,The value is: "+ entry.getValue());
        }

    }
}

class Dog implements Comparator<Dog> {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age &&
                Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compare(Dog o1, Dog o2) {
        return o2.getAge()-o1.getAge();
    }
}
