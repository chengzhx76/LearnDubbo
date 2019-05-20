package org.apache.dubbo.registry;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class RegistryFactory$Adaptive implements RegistryFactory {
    public Registry getRegistry(URL url) {
        if (url == null)
            throw new IllegalArgumentException("url == null");
        String extName = url.getProtocol() == null ? "dubbo" : url.getProtocol();
        if(extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.registry.RegistryFactory) name from url(" + url.toString() + ") use keys([protocol])");
        RegistryFactory extension = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getExtension(extName);
        return extension.getRegistry(url);
    }
}