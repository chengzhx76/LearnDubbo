package com.cheng.motan.client;

import com.cheng.motan.api.NameService;
import com.cheng.motan.api.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc:
 * Author: 光灿
 * Date: 2019/9/4
 */
public class DemoRpcClient {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:motan_demo_client.xml"});

        NameService service = (NameService) ctx.getBean("nameDemoReferer");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(service.getName(new People()));
            Thread.sleep(1000);
        }
        System.out.println("motan demo is finish.");
        System.exit(0);
    }
}
