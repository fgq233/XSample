package com.cxf.service;

import javax.jws.WebService;

/**
 * 基于CXF开发的服务端
 */
@WebService
public interface SampleService {

     String getCurrentTime(String param);

}
