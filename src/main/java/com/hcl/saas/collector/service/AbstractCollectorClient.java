package com.hcl.saas.collector.service;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

abstract class AbstractCollectorClient {

    abstract public Object getUsers() throws URISyntaxException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;

}
