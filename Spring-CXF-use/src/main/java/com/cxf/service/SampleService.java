
package com.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;



@WebService(name = "SampleService", targetNamespace = "http://service.cxf.com/")
@XmlSeeAlso({

})
public interface SampleService {

    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrentTime", targetNamespace = "http://service.cxf.com/", className = "com.cxf.service.GetCurrentTime")
    @ResponseWrapper(localName = "getCurrentTimeResponse", targetNamespace = "http://service.cxf.com/", className = "com.cxf.service.GetCurrentTimeResponse")
    public String getCurrentTime(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

}
