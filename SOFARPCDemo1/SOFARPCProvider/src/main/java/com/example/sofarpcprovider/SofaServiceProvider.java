package com.example.sofarpcprovider;

import com.example.sofarpcfacade.SofaService;

/**
 * sofa服务类
 */
public class SofaServiceProvider implements SofaService {

    @Override
    public void hello(String msg) {
        System.out.println("收到消息:"+msg);
        System.out.println("SofaServiceProvider 已提供服务");
    }
}
