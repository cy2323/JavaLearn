package com.aoki.test;

public class JavaTest3 {
    public static void main(String[] args) {
        String str = "hello*)(*()yootk(*#mldn*";
        String regex = "[a-z]";                        // 此处编写正则
        System.out.println(str.replaceAll(regex, ""));            // 字符串替换
    }

}
