package com.houyao.springtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class SpringTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private Person person;

    @Test
    public void testSpring(){
        //断言，判断person是否为空
        Assert.assertNotNull(person);
    }

}
