package com.houyao.collection.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 18:39:26 2019/8/7
 */
public class ListExample {
    public static void sop(Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args){
        ArrayList a1 = new ArrayList();
        a1.add("java01");
        a1.add("java02");
        a1.add("java03");
        sop(a1);
        example(a1);
        sop(a1);
        //使用迭代器遍历
        ListIterator li = a1.listIterator();
        while(li.hasNext()){
            Object obj = li.next();

            if(obj.equals("java01")){
                li.set("java009");
            }
        }
        sop(a1);
    }

    /**
     * 正确的遍历
     * @param list
     */
    public static void example(ArrayList list){
        for (int i=0;i<list.size();i++) {
            if(list.get(i).toString().equals("java01")){
                list.remove(list.get(i));
            }
        }
    }
}
