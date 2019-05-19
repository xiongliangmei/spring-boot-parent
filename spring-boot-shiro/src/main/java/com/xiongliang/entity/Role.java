package com.xiongliang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/***
 * 权限-角色 实体
 * @author xl
 * @date 2019-5-19 9:32
 */
@Entity
@Table(name = "T_SSO_ROLE")
@Data
public class Role extends BaseEntity{
    @Id
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id",unique = true,nullable = false,length = 56)
    private String id;
    @Column(name = "create_by")
    String createBy;
    @Column(name = "createDate")
    Date createDate;
    //组织机构id
    @Column(name = "organization_id",length = 56)
    private String organizationId;
    //角色名
    private String name;
    //角色英文名
    private String enname;
    //角色类型
    private  String roleType;

    private String dataScope;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="T_SSO_MENU_ROLE",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<Menu> permissions;

}
