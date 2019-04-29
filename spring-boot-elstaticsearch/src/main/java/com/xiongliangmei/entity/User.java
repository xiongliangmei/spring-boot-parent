package com.xiongliangmei.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Data
@Document(indexName = "user",type = "userType")
public class User implements Serializable {

    private String id;

    private String username;

    private String password;
}
