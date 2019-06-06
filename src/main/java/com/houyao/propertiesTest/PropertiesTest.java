package com.houyao.propertiesTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: houyao
 * @Description:将需要的配置写在properties中，通过不同的方法获取
 * @Date: Created in 17:14:50 2019/5/31
 */
public class PropertiesTest {
    public static void main(String[] args) {
        System.out.println(testGetSpringProperties());
        GetProperties.initInfo();
        System.out.println( GetProperties.getInfo("test"));
    }
    public static String testGetSpringProperties(){
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
        ac.start();
        return PropertyUtil.getProperty("test");
    }
}
