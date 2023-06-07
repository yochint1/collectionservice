package com.hcl.saas.collector.model;

import org.springframework.stereotype.Component;

@Component
public class CollectorRequest {


    public String serviceName;
    private String type;

    public String getServiceName() {
        return serviceName;
    }

    public String getType() {
        return type;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setType(String type) {
        this.type = type;
    }


}
