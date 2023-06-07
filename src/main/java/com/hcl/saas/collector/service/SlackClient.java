package com.hcl.saas.collector.service;

import com.hcl.saas.collector.model.UserList;
import com.hcl.saas.collector.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

@Component
public class SlackClient extends DirectIntegrationClient {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Value("${slack.url}")
    private String slackURL;

    @Value("${accessToken}")
    private String accessToken;


    public SlackClient() {
    }

    public Object getUsers() throws URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        RestTemplate restTemplate = getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + "xoxp-4216582544514-4216502868467-4224902803332-cab707543b8cc304bebf555fbd09f411");
        HttpEntity request = new HttpEntity(headers);
        URI uri = new URI("https://saas-management-group.slack.com/api/users.list");
        ResponseEntity<UserList> response = restTemplate.exchange(uri, HttpMethod.GET, request, UserList.class);
        UserList userList = response.getBody();
        return userList;
        /*for (User user : userList.getMembers()) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(user.getId());
            userInfo.setUsername(user.getName());
            userInfoRepository.save(userInfo);
        }*/
    }

    private static RestTemplate getRestTemplate() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

}
