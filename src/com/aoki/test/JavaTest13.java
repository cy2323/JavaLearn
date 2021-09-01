package com.aoki.test;

import com.aoki.test.memoizer.Memoizer;
import com.aoki.test.memoizer.interfaces.Computable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JavaTest13
 *
 * @author leo cao
 * @date 2021-03-24
 */
public class JavaTest13 {

    private static Map<Integer,String> map = new ConcurrentHashMap<>();
    private static Computable<Integer, String> c = new Computable<Integer, String>() {
        @Override
        public String computer(Integer arg) {

            return "1";
        }
    };
    private static Computable<Integer, String> comp = new Memoizer<Integer,String>(c);

    public static void main(String[] args) {
//        String leo = map.put(1, "leo");
//        System.out.println("==="+leo);
//
//        String s1 = map.get(1);
//        System.out.println("==="+s1);
//
//        String jack = map.putIfAbsent(2, "jack");
//        System.out.println("==="+jack);
//
//        String s2 = map.get(2);
//        System.out.println("==="+s2);

        String computer = comp.computer(1);

        System.out.println("==="+computer);

    }
}
