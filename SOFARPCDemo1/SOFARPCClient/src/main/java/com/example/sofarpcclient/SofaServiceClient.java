package com.example.sofarpcclient;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.example.sofarpcfacade.SofaService;

public class SofaServiceClient {
    public static void main(String[] args) {
        //客户端
        ConsumerConfig<SofaService> consumerConfig = new ConsumerConfig<SofaService>();
        consumerConfig.setProtocol("bolt") //指定协议
                .setInterfaceId(SofaService.class.getName()) //指定服务
                .setDirectUrl("bolt://127.0.0.1:12200"); //指定直连地址

        //生成代理类
        SofaService sofaService = consumerConfig.refer();

        //测试调用
        sofaService.hello("来呀");

    }
}
