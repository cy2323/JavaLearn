package com.aoki.test;

public class JavaTest12 {

    private static int hash;
    private static char[] value;

    public static void main(String[] args) {

        String str = "abcdefg";
        hash = 0;
        value = str.toCharArray();

        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        System.out.println("======"+h);
    }

}
