package com.houyao.typeTransform;

import java.lang.annotation.ElementType;
import java.util.ArrayList;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 18:37:00 2019/7/24
 */
public class Test {
    public static void main(String[] args) {
        char c = 'a';//97
        int num = 10;
        String str = "hello";
        //System.out.println(c + num +str);
        //System.out.println(c + str +num);

        System.out.println("*      *");
        System.out.println('*');
        System.out.println('*'+0);
        System.out.println('\t'+0);

        System.out.println('*'+'\t'+'*');
        System.out.println('*'+"\t"+'*');
        System.out.println('*'+"\t"+"*");
        System.out.println('*'+('\t'+"*"));

       ArrayList<String> list =  new ArrayList<String>();
        list.add("Java 1.5");
        list.add("Java 1.6");
        list.add("Scala");
        list.add("Python");
        list.add("Html");
        list.add("css");
        list.add("JavaScript");
        System.out.println("\nJAVA8:::Collection.forEach ======================>");


    }
}
