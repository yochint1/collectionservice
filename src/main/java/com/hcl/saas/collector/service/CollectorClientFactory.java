package com.hcl.saas.collector.service;

import org.springframework.stereotype.Component;

@Component
public class CollectorClientFactory {

    public AbstractCollectorClient createCollectorClient(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class c = Class.forName("com.hcl.saas.collector.service." + name +"Client");
        return (AbstractCollectorClient) c.newInstance();

    }
}
