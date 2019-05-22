package com.houyao.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 不基于特定的类
 */
public class QuartzTestJob3 {
    private static final Logger logger = LoggerFactory.getLogger(QuartzTestJob3.class);

    public void executeJob() {
        logger.info("定时任务3进行中.......");
    }
}
