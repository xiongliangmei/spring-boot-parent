package com.xiongliang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
public class BaseEntity {

    @Id
    @GenericGenerator(name = "continue",strategy = "uuid")
    @GeneratedValue(generator = "continue")
    @Column(name = "id",unique = true,nullable = false,length = 32)
    private String id;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "createDate")
    private Date createDate;
}
