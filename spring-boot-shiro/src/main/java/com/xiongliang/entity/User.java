package com.xiongliang.entity;

import com.sun.naming.internal.FactoryEnumeration;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "T_SSO_USER")
@Entity
@Data
public class User  extends BaseEntity{

    @Id
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id",unique = true,nullable = false,length = 56)
    private String id;
    @Column(name = "create_by")
    String createBy;
    @Column(name = "createDate")
    Date createDate;
    //公司id
    @Column(name = "company_id",length = 56)
    private String companyId;
    //登陆名
    @Column(name = "username",length = 255)
    private String username;
    //密码
    @Column(name = "password",length = 255)
    private String password;
    //密码盐
    private String salt;
    //区域code
    @Column(name = "area_code")
    private String areaCode;
    //姓名
    private String name;
    //邮箱
    private String email;
    //电话
    private String phones;
    //手机
    private String mobile;
    //用户类型
    @Column(name = "user_type")
    private String userType;
    //头像
    @Column(name = "photo")
    private String photo;
    //ip
    @Column(name = "login_ip")
    private String loginIp;
    //登陆时间
    @Column(name = "login_date")
    private Date loginDate;
    //账号是否冻结
    @Column(name = "login_flag")
    private boolean loginFlag;
    @ManyToMany(fetch = FetchType.EAGER) //立即从数据库加载
    @JoinTable(name = "T_SSO_USER_ROLE",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;

}
