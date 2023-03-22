package com.example.sofarpcprovider;

import com.alipay.sofa.rpc.common.RpcConstants;
import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.example.sofarpcfacade.SofaService;
import org.apache.curator.RetryPolicy;

public class SofaServiceProviderPublish {
    public static void main(String[] args) {
//        directPublish();
        registerPublish();
    }

    /**
     * 直连服务提供者
     */
    private static void directPublish() {
        //运行容器（服务地址）
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

    /**
     * 注册中心提供服务着
     */
    private static void registerPublish() {
        //注册中心
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol(RpcConstants.REGISTRY_PROTOCOL_ZK) //注册中心协议
                .setAddress("192.168.100.176:2182"); //注册地址

        //运行容器
        ServerConfig serverConfig =  new ServerConfig();
        serverConfig.setPort(8803)
                .setProtocol("bolt");

        //服务发布
        ProviderConfig<SofaService> providerConfig = new ProviderConfig<SofaService>();
        providerConfig.setServer(serverConfig)
                .setRegistry(registryConfig)
                .setInterfaceId(SofaService.class.getName())
                .setRef(new SofaServiceProvider());

        //服务发布
        providerConfig.export();

    }
}
