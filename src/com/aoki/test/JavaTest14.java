package com.aoki.test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class JavaTest14 {

    public static void main(String[] args) {

        /**
         * TreeMap 继承自 SortedMap，所以输出都是有序的！
         */
        Map<Integer,String> map = new TreeMap<>();

        map.put(2,"l");
        map.put(6,"e");
        map.put(4,"r");
        map.put(3,"d");

        Iterator iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }


        Map<Integer,String> hashMap = new HashMap<>();


        hashMap.put(3,"john");
        hashMap.put(1,"leo");
        hashMap.put(2,"jack");

        Iterator iterator2 = hashMap.entrySet().iterator();

        while(iterator2.hasNext())
        {
            System.out.println(iterator2.next());
        }

    }
}
