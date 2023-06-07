package com.hcl.saas.collector.service;

import com.hcl.saas.collector.model.CollectorRequest;
import com.hcl.saas.collector.model.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Service
public class CollectorService {

    @Autowired
    private CollectorClientFactory clientFactory;

    public Object processRequest(CollectorRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        AbstractCollectorClient client = clientFactory.createCollectorClient(request.getServiceName());

        if (request.getType().equals("getUsers")){
            return client.getUsers();
        }

        return null;
    }

}
