package com.cy.store.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: BaseEntity
 * @Author Alvin
 * @Package com.cy.store.entity
 * @Date 2023/4/18 21:28
 * @description: 作为实体类的基类
 */

@Data
public class BaseEntity implements Serializable {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
