package com.example.sofarpcclient;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.example.sofarpcfacade.SofaService;

public class SofaServiceClient {
    public static void main(String[] args) {
//        directClient();
        registryClient();
    }

    /**
     * 客户端直连方式
     */
    private static void directClient() {
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

    /**
     * 客户端注册中心（zookeeper）方式
     */
    private static void registryClient() {

        //注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper") //注册中心协议
                .setAddress("192.168.100.176:2182"); //注册地

        //客户端
        ConsumerConfig<SofaService> consumerConfig = new ConsumerConfig<SofaService>();
        consumerConfig.setInterfaceId(SofaService.class.getName())
                .setRegistry(registryConfig);

        //生成代理
        SofaService sofaService = consumerConfig.refer();

        //调用
        sofaService.hello("小飞棍");

    }
}
