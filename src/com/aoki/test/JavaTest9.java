package com.aoki.test;

import java.util.HashMap;
import java.util.Map;

public class JavaTest9 {


    static Map<String, Object> map = new HashMap<>();

    private JavaTest9() {
        map.put("leo", this);
    }

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();

        System.out.println("1.     " + map.get("leo"));

    }
}
