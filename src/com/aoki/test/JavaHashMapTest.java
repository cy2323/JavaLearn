package com.aoki.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 记住结论： a%b的值一定等于a&(b-1)的值
 * @author Cao Yong
 * @date 2021-05-04
 */
    public class JavaHashMapTest {

    public static void main(String[] args) {
//        System.out.println(" 1."+Math.pow(2,5));
//        final double pow = Math.pow(2, 5);
//        System.out.println(" 2."+ 14%pow);
//        final int i = (14 & 31);
//        System.out.println(" 3."+ i);


        HashMap<Integer,String> map  = new HashMap<>(10);

//        for(int k =0;k<=10000;k++){
//            map.put(k,"aaa"+k);
//        }

        map.put(1,"leo");
        map.put(2,"jack");
        map.put(3,"lily");
        map.put(3,"john");      // 会替换掉前一个键为3的对象

        /**
         * 输出：
         *  1=leo
         *  2=jack
         *  3=john        // 替换掉了前一个3对应的lily值
         * ----------------------
         *  1
         *  2
         *  3
         */

        // 遍历方式 1
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        // 遍历方式 2
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(" "+iterator.next());
        }
        System.out.println("----------------------");
        while (iterator1.hasNext()){
            System.out.println(" "+iterator1.next());
        }


//        String s = map.get(8888);
//        System.out.println(" 4."+s);


    }
}
