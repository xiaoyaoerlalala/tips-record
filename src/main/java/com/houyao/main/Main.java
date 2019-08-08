package com.houyao.main;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = null;
        try {
            ac = new ClassPathXmlApplicationContext("spring/spring.xml");
            ac.start();
        } catch (BeansException e) {
            e.printStackTrace();
        } finally {
            ac.stop();
            ac.destroy();
        }

    }
}
