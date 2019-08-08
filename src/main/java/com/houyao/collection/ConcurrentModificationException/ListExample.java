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
        ListIterator li = a1.listIterator();
        while(li.hasNext()){
            Object obj = li.next();

            if(obj.equals("java01")){
                li.set("java009");
            }
        }
        sop(a1);
    }
}
