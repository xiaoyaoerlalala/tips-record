package com.houyao.lambda;

/**
 * 无参数，无返回值
 * () -> System.out.println("Hello Lambda!");
 */
public class Test {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }
}
