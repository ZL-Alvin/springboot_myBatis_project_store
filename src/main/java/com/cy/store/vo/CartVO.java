package com.cy.store.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title: CartVO
 * @Author Alvin
 * @Package com.cy.store.vo
 * @Date 2023/4/27 16:57
 * @description: 购物车和商品的值对象
 */
@Data
public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Long price;
    private Integer num;
    private Integer pid;
    private String title;
    private String image;
    private Long realPrice;
}
