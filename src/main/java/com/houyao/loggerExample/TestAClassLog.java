package com.houyao.loggerExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: houyao
 * @Description:某个类的日志单独输出到一个日志文件中
 * @Date: Created in 14:25:58 2019/6/12
 */
public class TestAClassLog {
    public static final Logger logger = LoggerFactory.getLogger("Aclasslog");

    public static void testAClassLog(){
        logger.info("单独输出哦");
    }
    /*
        保持JAVA代码实例标签Aclasslog和配置文件中的LOGGER NAME属性一致即可。
     */
}
