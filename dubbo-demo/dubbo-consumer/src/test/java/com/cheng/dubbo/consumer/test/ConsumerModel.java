package com.cheng.dubbo.consumer.test;

import com.cheng.dubbo.NameInterface;
import com.cheng.dubbo.People;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * @desc:
 * @author: hp
 * @date: 2019/9/9
 */
public class ConsumerModel {

    public static void main(String[] args) {
        ReferenceConfig<NameInterface> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("cheng-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://139.196.35.134:2181", "zookeeper"));
        reference.setInterface(NameInterface.class);
        NameInterface service = reference.get();

        String message = service.getName(new People());
        System.out.println(message);
    }

}
