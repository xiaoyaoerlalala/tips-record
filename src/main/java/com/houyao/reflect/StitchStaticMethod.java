package com.houyao.reflect;

import java.lang.reflect.Method;

/**
 * 当调用的方法需要动态拼接时，无法使用拼接后的字符串调用方法，可以通过反射来实现
 */
public class StitchStaticMethod {
    public static void main(String[] args) {
        try {
            String className = "com.houyao.reflect.Use";
            Class<?> testClass = Class.forName(className);
            Method saddMethod2 = testClass.getMethod("demo", new Class[]{String.class});
            String result = saddMethod2.invoke(null, new Object[]{"测试反射"}).toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

