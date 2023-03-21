package com.example.sofarpcprovider;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.example.sofarpcfacade.HelloSofaService;
import org.springframework.stereotype.Service;

@Service
@SofaService(uniqueId = "helloSofa",bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class HelloSofaServiceImpl implements HelloSofaService {

    @Override
    public void hello(String msg) {
        System.out.println("接收到:"+msg);
        System.out.println("provider已提供服务");
    }
}
