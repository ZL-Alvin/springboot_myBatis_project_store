package com.cy.store.entity;

import lombok.Data;

/**
 * @Title: Cart
 * @Author Alvin
 * @Package com.cy.store.entity
 * @Date 2023/4/27 13:48
 * @description: 购物车实体类
 */
@Data
public class Cart extends BaseEntity{
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
}
