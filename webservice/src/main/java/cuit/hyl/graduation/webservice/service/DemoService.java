package cuit.hyl.graduation.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "DemoService", // 暴露服务名称
        targetNamespace = "http://service.webservice.graduation.hyl.cuit"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {

    @WebMethod
    String hello(@WebParam(name = "name") String name);
}

