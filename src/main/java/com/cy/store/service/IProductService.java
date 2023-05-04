package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

/**
 * @Title: IProductService
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/26 21:43
 * @description: 商品的服务层接口
 */

public interface IProductService {
    /**
     * 查询热销前四的商品
     * @return 商品列表
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详细信息
     * @param id 商品id
     * @return 返回商品信息
     */
    Product findById(Integer id);
}
