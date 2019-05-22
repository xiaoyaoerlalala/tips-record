package com.houyao.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 继承父类
 */
public class QuartzTestJob extends QuartzJobBean {

    public QuartzTestJob() {
        super();
    }

    private static final Logger logger = LoggerFactory.getLogger(QuartzTestJob.class);
    private Integer timeout;

    //调度工厂实例化后，经过timeout时间开始执行调度
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("定时任务1进行中.......");
    }

}
