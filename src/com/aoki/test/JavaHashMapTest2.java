package com.aoki.test;

import java.util.HashMap;
import java.util.Map;

public class JavaHashMapTest2 {

    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();

        map.put(1,"leo");
        map.put(2,"jack");
        map.put(3,"john");


        map.remove(3);

        for (Map.Entry entry:map.entrySet()) {
            System.out.println(" "+entry);
        }
    }
}
