package com.github.chengzhx76.rpc.framework.test;

import com.github.chengzhx76.rpc.framework.core.RpcFramework;

/**
 * Desc:
 * Author: 光灿
 * Date: 2019/5/26
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
