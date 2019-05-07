package com.xiongliang.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Author implements Serializable {
    private String id;
    private String name;
    private String intro_l;
}
