package com.xiongliang.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "user",type = "userType")
public class User implements Serializable {

    private String id;

    private String username;

    private String password;
}
