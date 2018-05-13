Apache CXF
    使用服务
方式一、使用WebService的使用方式
       解析WDDL：wsimport -s path http://192.168.3.8:8888/cxf/service/sample?wsdl
                            path：生成文件的相对存放地址

方式二、使用CXF框架提供的使用方式
    1、添加依赖

    2、使用 wsimport 命令或者 CXF提供的 wsdl2java 命令(需进入cxf目录或者配置wsdl2java环境变量)生成本地代码
                解析WDDL：wsdl2java -d -p path http://192.168.3.8:8888/cxf/service/sample?wsdl

    3、将生成的接口文件拷贝到项目中

    4、提供Spring配置文件，注册客户端代理对象

    5、像Spring使用Bean那样使用Service
