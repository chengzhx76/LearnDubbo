package org.apache.dubbo.cluster;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.cluster.Configurator;
import org.apache.dubbo.rpc.cluster.ConfiguratorFactory;

public class ConfiguratorFactory$Adaptive implements ConfiguratorFactory {
    public Configurator getConfigurator(URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getProtocol();
        if(extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.cluster.ConfiguratorFactory) name from url(" + url.toString() + ") use keys([protocol])");
        ConfiguratorFactory extension = ExtensionLoader.getExtensionLoader(ConfiguratorFactory.class).getExtension(extName);
        return extension.getConfigurator(arg0);
    }
}
