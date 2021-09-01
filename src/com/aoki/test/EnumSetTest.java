package com.aoki.test;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetTest {

    enum animals{
        DOG,CAT,CHINKEN,DUCK,PANDA,FISH,BIRD
    }

    public static void main(String[] args) {

        EnumSet set = EnumSet.allOf(animals.class);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println("   "+iterator.next());
        }

        System.out.println("=================");

        EnumMap<animals,Integer> map = new EnumMap<>(animals.class);
        map.put(animals.DOG,10);
        map.put(animals.CAT,11);
        map.put(animals.CHINKEN,12);
        map.put(animals.DUCK,13);
        map.put(animals.PANDA,14);
        map.put(animals.FISH,15);
        map.put(animals.BIRD,16);
        Iterator iterator2 = map.entrySet().iterator();

        while (iterator2.hasNext()){
            System.out.println("   "+iterator2.next());
        }

    }
}
