package com.houyao.jdk8.lambda;

import java.util.function.Consumer;

/**
 * 有一个参数，并且无返回值
 * (x) -> System.out.println(x)
 * 如果只有一个参数的情况下小括号是可以省略的,可以写成：x -> System.out.println(x)
 */
public class Test2 {
    public static void main(String[] args) {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Hello Lambda!");
    }
}
