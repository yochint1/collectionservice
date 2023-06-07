package com.hcl.saas.collector.service;

import com.google.gson.Gson;
import com.hcl.saas.collector.model.Constants;
import com.hcl.saas.collector.repository.UserInfoRepository;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

@Component
public class ZoomClient extends DirectIntegrationClient {

    @Autowired
    UserInfoRepository userInfoRepository;

    public ZoomClient() {
    }

    public Object getUsers() throws URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String token = getToken();
        RestTemplate restTemplate = getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + token);
        HttpEntity request = new HttpEntity(headers);
        URI uri = new URI("https://api.zoom.us/v2/users");
        ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.GET, request, Object.class);
        return response.getBody();
    }

    private static String getToken() throws URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        RestTemplate restTemplate = getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", getBasicAuthenticationHeader());
        HttpEntity request = new HttpEntity(headers);
        URI uri = new URI("https://zoom.us/oauth/token?grant_type=account_credentials&account_id=vtBhn4fRTOmwCquXVLGhOQ");
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        Gson gson = new Gson();
        Map map = gson.fromJson(response.getBody(), Map.class);
        return (String) map.get("access_token");
    }

    private static final String getBasicAuthenticationHeader() {
        String valueToEncode = "fzpmKUHSKipofgqWfiYxQ" + ":" + "c22Uga95kG2bh37VLyqC0bh3EMNTPc20";
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
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
