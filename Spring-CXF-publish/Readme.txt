一、关于WebService
    1、WebService：多个系统之间的远程调用技术、可以跨语言(因为是基于Http协议、传输的数据格式为xml)

    2、SOAP：简单对象访问协议 (基于Http协议，是一个文本协议，规范了请求体、响应体格式)

    3、WSDL：Web服务描述语言(WebService使用说明书)，
            一个网络服务对应一个WSDL，描述了：请求地址、方法名、返回值等信息

    4、一般不会直接使用原生WebService发布服务、使用服务，而是使用Apache CXF框架来发布服务、使用服务

    5、特点：所有WebService通过POST方式接受请求
            使用SOAP协议传输XML数据
            跨平台、跨语言

二、Apache CXF
发布服务

    1、添加依赖

    2、在web.xml中配置CXF提供的一个Servlet：CXFServlet

    3、指定cxf配置文件位置(默认：/WEB-INF/cxf-servlet.xml),这是一个Spring配置文件

    4、开发一个接口(接口上使用@WebService表明这是一个网络服务)、接口实现类

    5、在cxf配置文件中注册服务


