package com.cxf.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleServiceImpl implements SampleService {


    public String getCurrentTime(String param){
        System.out.println("★★★   CXF服务端被调用   ★★★");
        return param + "------" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


}
