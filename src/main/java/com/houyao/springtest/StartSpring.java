package com.houyao.springtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: houyao
 * @Description:
 * @Date: Created in 18:22 2019/5/30
 */
public class StartSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
        ac.start();
    }
}
