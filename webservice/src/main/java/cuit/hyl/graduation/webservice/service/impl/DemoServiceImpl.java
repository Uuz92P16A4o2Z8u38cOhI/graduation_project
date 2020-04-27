package cuit.hyl.graduation.webservice.service.impl;

import cuit.hyl.graduation.webservice.service.DemoService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(serviceName = "DemoService", // 与接口中指定的name一致
        targetNamespace = "http://service.webservice.graduation.hyl.cuit/",// 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "cuit.hyl.graduation.webservice.service.DemoService"
)
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
