package com.dubbo.provider;

import com.dubbo.api.SampleService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleServiceImpl implements SampleService {

    @Override
    public String sayHello(String target) {
        return "Hello:" + target;
    }

    @Override
    public String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
