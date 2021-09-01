package com.aoki.test;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * redis 的键三大过期策略和6大内存淘汰策略
 * redis 中的LRU（最近最少使用）算法实现，取队列中经常用的元素放到队列的头部，排在尾部的就是不经常用的，如果要通过删除策略定期删除可以从尾部删除！
 * @Author CaoYong
 * @Date 2021-04-22
 */
public class LRUAlgorithm {

    private static final int COUNT_THRESHOLD = 3;

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> lists = new CopyOnWriteArrayList<>();

        lists.add(0);
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
        lists.add(7);
        lists.add(8);
        lists.add(9);

        Iterator<Integer> iterator = lists.iterator();
        Random random = new Random();

        while(iterator.hasNext()){
            int curValue = iterator.next();
            for(int i = 0;i < COUNT_THRESHOLD ;i++){
                int iRandom = random.nextInt(10);
                if(iRandom == curValue){
                    lists.remove(lists.indexOf(curValue));
                    lists.add(curValue);
                }
            }
            System.out.print(" "+iterator.next());

        }
    }
}
