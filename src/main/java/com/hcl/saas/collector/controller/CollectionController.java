package com.hcl.saas.collector.controller;

import com.hcl.saas.collector.model.CollectorRequest;
import com.hcl.saas.collector.model.UserInfo;
import com.hcl.saas.collector.model.UserList;
import com.hcl.saas.collector.repository.UserInfoRepository;
import com.hcl.saas.collector.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class CollectionController {

    @Autowired
    private CollectorService collectorService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/processRequest")
    public ResponseEntity<?> runProcessRequest(@RequestParam(name = "serviceName") String serviceName,
                                            @RequestParam(name = "type") String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CollectorRequest collectorRequest = new CollectorRequest();
        collectorRequest.setServiceName(serviceName);
        collectorRequest.setType(type);
        return new ResponseEntity<>(collectorService.processRequest(collectorRequest), HttpStatus.OK);

    }

    @GetMapping("/userDBList")
    public ResponseEntity<List<UserInfo>> getUserList() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<UserInfo> list = (List<UserInfo>) userInfoRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
