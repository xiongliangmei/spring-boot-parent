package com.xl.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class User implements Serializable {

    @Id
    private String id;
    private String username;
    private Integer age;

    private double[] position;//位置信息


    public User(String id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public User(String id,String username,Integer age, double lon, double lat) {
        this.id = id;
        this.username = username;
        this.age = age;
        double[] p = new double[]{lon, lat};
        this.position = p;
    }
}
