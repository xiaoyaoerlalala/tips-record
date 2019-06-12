package com.houyao.loggerExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: houyao
 * @Description:打印日志示例
 * @Date: Created in 14:32:32 2019/6/11
 */
public class LoggerExample {
    public static final Logger logger = LoggerFactory.getLogger(LoggerExample.class);

    public static void main(String[] args) {
        int a = 1;
        logger.info("a的值是{}，a的平方是{}", a, a*a);
        try{
            a = a/0;
        } catch(Exception e) {
            logger.error("执行出现异常：" + e.getMessage());
        }
        TestAClassLog.testAClassLog();
    }
}
