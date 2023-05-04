package com.cy.store.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Title: CartServiceTest
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/27 15:17
 * @description: 购物车服务层测试
 */
@SpringBootTest
public class CartServiceTest {
    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart() {
        cartService.addToCart(21, 10000003, 10, "张明");
    }
}
