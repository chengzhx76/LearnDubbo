package org.apache.dubbo.cache;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Invocation;

public class CacheFactory$Adaptive implements CacheFactory {
    // todo 需要修改
    public Cache getCache(URL arg0, Invocation invocation) {
        if (arg0 == null)
            throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getParameter("cache", "lru");
        if(extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.cache.CacheFactory) name from url(" + url.toString() + ") use keys([cache])");
        CacheFactory extension = ExtensionLoader.getExtensionLoader(CacheFactory.class).getExtension(extName);
        return extension.getCache(arg0, invocation);
    }
}