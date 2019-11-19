package com.houyao.classexample;

/**
 * 匿名内部类实际上是一个继承了该类或者实现了该接口的子类匿名对象，是对象！！！！！！！！！！！！！
 */
public class InnerClassExample {
    public void method() {
        new Inner() {
            public void info() {
                System.out.println("HelloWorld");
            }
        }.info();
    }

    public static void main(String[] args) {
        InnerClassExample outer = new InnerClassExample();
        outer.method();
    }
}

interface Inner
{
    public void info();
}
