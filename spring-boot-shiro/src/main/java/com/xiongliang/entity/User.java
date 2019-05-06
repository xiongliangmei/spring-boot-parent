package com.xiongliang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Table(name = "T_SSO_USER")
@Entity
@Data
public class User  extends BaseEntity{
    @Column(name = "organization_id",length = 56)
    private String organizationId;

    @Column(name = "company_id",length = 56)
    private String companyId;

    @Column(name = "login_name",length = 255)
    private String loginName;
    @Column(name = "password",length = 255)
    private String password;
    private String areaCode;
    private String name;
    private String email;
    private String phones;
    private String mobile;
    private String userType;
    private String photo;
    private String loginIp;
    private Date loginDate;
    private boolean loginFlag;

}
