package org.apache.dubbo.rpc;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class Protocol$Adaptive implements Protocol {

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("method public abstract void com.alibaba.dubbo.rpc.Protocol.destroy() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!");
    }

    @Override
    public int getDefaultPort() {
        throw new UnsupportedOperationException("method public abstract int com.alibaba.dubbo.rpc.Protocol.getDefaultPort() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!");
    }

    @Override
    public Invoker refer(Class arg0, URL arg1) throws RpcException {
        if (arg1 == null)
            throw new IllegalArgumentException("url == null");

        URL url = arg1;
        String extName = url.getProtocol() == null ? "dubbo" : url.getProtocol();

        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.Protocol) name from url(" + url.toString() + ") use keys([protocol])");

        Protocol extension = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName);

        return extension.refer(arg0, arg1);
    }

    @Override
    public Exporter export(Invoker arg0) throws RpcException {
        if (arg0 == null)
            throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument == null");
        if (arg0.getUrl() == null)
            throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument getUrl() == null");
        URL url = arg0.getUrl();

        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());

        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.Protocol) name from url(" + url.toString() + ") use keys([protocol])");

        Protocol extension = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName);

        return extension.export(arg0);
    }
}