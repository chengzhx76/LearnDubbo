package com.cheng.motan.client;

import com.cheng.motan.api.NameService;
import com.cheng.motan.api.People;
import com.weibo.api.motan.config.ProtocolConfig;
import com.weibo.api.motan.config.RefererConfig;
import com.weibo.api.motan.config.RegistryConfig;

/**
 * @desc:
 * @author: hp
 * @date: 2019/9/10
 */
public class DemoRpcModelClient {
    public static void main(String[] args) {
        RefererConfig<NameService> motanDemoServiceReferer = new RefererConfig<>();

        // 设置接口及实现类
        motanDemoServiceReferer.setInterface(NameService.class);

        // 配置服务的group以及版本号
        motanDemoServiceReferer.setGroup("motan-demo-rpc");
        motanDemoServiceReferer.setVersion("1.0");
        motanDemoServiceReferer.setRequestTimeout(1000);

        // 配置注册中心直连调用
        RegistryConfig registry = new RegistryConfig();

        //use direct registry
        registry.setRegProtocol("direct");
        registry.setAddress("127.0.0.1:8002");

        // use ZooKeeper registry
//        registry.setRegProtocol("zookeeper");
//        registry.setAddress("127.0.0.1:2181");
        motanDemoServiceReferer.setRegistry(registry);

        // 配置RPC协议
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setId("motan");
        protocol.setName("motan");
        motanDemoServiceReferer.setProtocol(protocol);
        // motanDemoServiceReferer.setDirectUrl("localhost:8002");  // 注册中心直连调用需添加此配置

        // 使用服务
        NameService service = motanDemoServiceReferer.getRef();
        System.out.println(service.getName(new People()));

        System.exit(0);
    }
}
