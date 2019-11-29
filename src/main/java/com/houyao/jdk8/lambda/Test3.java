package com.houyao.jdk8.lambda;

import java.util.Comparator;

/**
 * 有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
 */
public class Test3 {
    public static void main(String[] args) {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
        int compare = com.compare(1, 2);
        /*----我是分割线----*/
        /**
         * 若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
         * Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
         */
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        int compare1 = com1.compare(1, 2);
    }
}
