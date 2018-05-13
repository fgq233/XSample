package com.quartz.sample;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务类：继承QuartzJobBean，或者实现Job接口
 */
public class MyJob2 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
