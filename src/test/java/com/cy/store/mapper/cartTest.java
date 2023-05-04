package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Title: cartTest
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/27 14:20
 * @description: 购物车dao层测试
 */
@SpringBootTest
public class cartTest {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insertTest() {
        Cart cart = new Cart();
        cart.setUid(21);
        cart.setPid(10000011);
        cart.setNum(2);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid() {
        cartMapper.updateNumByCid(2, 4, "张三", new Date());
    }

    @Test
    public void findByUidAndPid() {
        System.out.println(cartMapper.findByUidAndPid(21, 10000011));
    }

    @Test
    public void findVOByUid() {
        System.out.println(cartMapper.findVOByUid(21));
    }
}
