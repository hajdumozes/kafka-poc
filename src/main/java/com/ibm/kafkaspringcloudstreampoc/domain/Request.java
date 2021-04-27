package com.ibm.kafkaspringcloudstreampoc.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Request {
    UUID id;
    Status status;

    public enum Status {
        DONE
    }
}
