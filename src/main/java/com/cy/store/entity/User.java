package com.cy.store.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Title: User
 * @Author Alvin
 * @Package com.cy.store.entity
 * @Date 2023/4/18 21:35
 * @description: 用户的实体类
 */

@Data
public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String PASSWORD;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;


    public User() {}

    public User(Integer uid, String avatar, String username) {
        this.uid = uid;
        this.avatar = avatar;
        this.username = username;
    }
}
