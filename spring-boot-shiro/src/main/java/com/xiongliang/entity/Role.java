package com.xiongliang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    @JoinTable(name="MenuRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<Menu> permissions;

    // 用户 - 角色关系定义;
    @ManyToMany
    @JoinTable(name="UserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    private List<User> userInfo;// 一个角色对应多个用户
}
