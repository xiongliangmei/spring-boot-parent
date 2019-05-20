package com.xiongliang.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User  implements Serializable {
    private String a;
    private String b;
    private String c;
    private String d;
    private String f;

    public User(String a, String b, String c, String d,String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = d;
    }
}
