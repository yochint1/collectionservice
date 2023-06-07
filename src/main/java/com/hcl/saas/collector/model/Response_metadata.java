package com.hcl.saas.collector.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Response_metadata {
    private String next_cursor;

    // Getter Methods

    public String getNext_cursor() {
        return next_cursor;
    }

    // Setter Methods

    public void setNext_cursor(String next_cursor) {
        this.next_cursor = next_cursor;
    }
}
