package com.quartz.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务类
 */
public class MyJob1 {

    public void run(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
