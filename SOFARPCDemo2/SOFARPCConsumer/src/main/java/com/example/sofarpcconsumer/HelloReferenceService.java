package com.example.sofarpcconsumer;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.example.sofarpcfacade.HelloSofaService;
import org.springframework.stereotype.Service;


@Service
public class HelloReferenceService{

    @SofaReference(uniqueId = "helloSofa",binding = @SofaReferenceBinding(bindingType = "bolt"))
    HelloSofaService helloSofaService;

    public void hello() {
        helloSofaService.hello("测试");
    }
}
