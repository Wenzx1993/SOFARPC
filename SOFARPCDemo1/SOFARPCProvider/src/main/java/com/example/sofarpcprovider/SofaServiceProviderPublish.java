package com.example.sofarpcprovider;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.example.sofarpcfacade.SofaService;

public class SofaServiceProviderPublish {
    public static void main(String[] args) {
        //注册中心（服务地址）
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setProtocol("bolt") //指定协议
                .setPort(12200) //指定端口
                .setDaemon(false); //是否守护线程

        //服务端
        ProviderConfig<SofaService> providerConfig = new ProviderConfig<SofaService>();
        providerConfig.setInterfaceId(SofaService.class.getName()) // 指定接口
                .setRef(new SofaServiceProvider()) //指定实现
                .setServer(serverConfig); //指定服务端

        //发布服务
        providerConfig.export();
    }
}
