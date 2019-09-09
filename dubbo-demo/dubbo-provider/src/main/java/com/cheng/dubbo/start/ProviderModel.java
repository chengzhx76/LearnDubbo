package com.cheng.dubbo.start;

import com.cheng.dubbo.NameInterface;
import com.cheng.dubbo.impl.NameInterfaceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

/**
 * @desc:
 * @author: hp
 * @date: 2019/9/9
 */
public class ProviderModel {

    public static void main(String[] args) throws Exception {
        ServiceConfig<NameInterface> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://139.196.35.134:2181"));
        service.setInterface(NameInterface.class);
        service.setRef(new NameInterfaceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
