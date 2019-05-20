package org.apache.dubbo.remoting.zookeeper;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class ZookeeperTransporter$Adaptive implements ZookeeperTransporter {
    public ZookeeperClient connect(URL arg0)  {
        if (arg0 == null)
            throw new IllegalArgumentException("url == null");

        URL url = arg0;
        String extName = url.getParameter("client", url.getParameter("transporter", "curator"));

        if(extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.remoting.zookeeper.ZookeeperTransporter) name from url (" + url.toString() + ") use keys([client, transporter])");

        ZookeeperTransporter extension = ExtensionLoader.getExtensionLoader(ZookeeperTransporter.class).getExtension(extName);
        return extension.connect(arg0);
    }
}