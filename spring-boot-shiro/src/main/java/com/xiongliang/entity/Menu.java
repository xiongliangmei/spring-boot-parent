package com.xiongliang.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/***
 * 权限-资源
 * @author xl
 * @date 2019-5-19 9:39
 */
@Table(name = "T_SSO_MENU")
@Entity
@Data
public class Menu extends BaseEntity{
    //父级
    @Column(name = "parent_id")
    private String parentId;
    @Column(name = "parent_ids")
    //父级链路
    private String parentIds;
    //姓名
    private String name;
    private String sort;
    private String uri;
    private String target;
    private String icon;
    private String systemId;
    private int isShow;
    private String permission;

    @ManyToMany
    @JoinTable(name="MenuRole",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<Role> roles;

}