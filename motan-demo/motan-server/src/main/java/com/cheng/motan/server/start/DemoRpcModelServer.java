package com.cheng.motan.server.start;

import com.cheng.motan.api.NameService;
import com.cheng.motan.server.NameServiceImpl;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.config.ProtocolConfig;
import com.weibo.api.motan.config.RegistryConfig;
import com.weibo.api.motan.config.ServiceConfig;
import com.weibo.api.motan.util.MotanSwitcherUtil;

/**
 * @desc:
 * @author: hp
 * @date: 2019/9/5
 */
public class DemoRpcModelServer {

    public static void main(String[] args) {

        ServiceConfig<NameService> motanDemoService = new ServiceConfig<>();

        // 设置接口及实现类
        motanDemoService.setInterface(NameService.class);
        motanDemoService.setRef(new NameServiceImpl());

        // 配置服务的group以及版本号
        motanDemoService.setGroup("motan-demo-rpc");
        motanDemoService.setVersion("1.0");
        motanDemoService.setAccessLog("true");
        motanDemoService.setShareChannel(true);
        motanDemoService.setModule("motan-demo-rpc");

        // 配置注册中心直连调用
        RegistryConfig registry = new RegistryConfig();

        //use local registry
//        registry.setRegProtocol("local");

//         use ZooKeeper registry
        registry.setRegProtocol("zookeeper");
        registry.setAddress("139.196.35.134:2181");

        // registry.setCheck("false"); //是否检查是否注册成功
        motanDemoService.setRegistry(registry);

        // 配置RPC协议
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("motan");
        protocol.setId("demoMotan");
        protocol.setMaxServerConnection(80000);
        protocol.setMaxContentLength(1048576);
        protocol.setMaxWorkerThread(800);
        protocol.setMinWorkerThread(20);
        motanDemoService.setProtocol(protocol);

        motanDemoService.setExport("demoMotan:8001");
        motanDemoService.export();

        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);

        System.out.println("server start...");

    }


}
