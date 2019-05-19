package com.xiongliang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

public class BaseEntity {
    @Id
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id",unique = true,nullable = false,length = 56)
    private String id;
    @Column(name = "create_by")
    String createBy;
    @Column(name = "createDate")
    Date createDate;
}
