package com.cy.store.mapper;

import com.cy.store.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: ProductMapper
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/26 21:39
 * @description: 商品对应的mapper文件
 */
@Repository
public interface ProductMapper {
    /**
     * 查询热销商品的前四
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配商品的详情，如果没有匹配的数据则返回null
     */
    Product findById(Integer id);
}
