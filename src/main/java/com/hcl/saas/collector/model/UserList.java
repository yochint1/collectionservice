package com.hcl.saas.collector.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;

@DynamoDBTable(tableName = "UserList")
public class UserList {

    private boolean ok;

    private ArrayList<User> members = new ArrayList<User>();

    @DynamoDBHashKey
    private float cache_ts;
    Response_metadata Response_metadataObject;


    // Getter Methods

    public boolean getOk() {
        return ok;
    }

    public float getCache_ts() {
        return cache_ts;
    }

    public Response_metadata getResponse_metadata() {
        return Response_metadataObject;
    }

    // Setter Methods

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public void setCache_ts(float cache_ts) {
        this.cache_ts = cache_ts;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public void setResponse_metadata(Response_metadata response_metadataObject) {
        this.Response_metadataObject = response_metadataObject;
    }
}

