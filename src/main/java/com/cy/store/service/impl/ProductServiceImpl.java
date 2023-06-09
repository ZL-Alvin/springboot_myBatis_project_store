package com.cy.store.service.impl;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: ProductServiceImpl
 * @Author Alvin
 * @Package com.cy.store.service.impl
 * @Date 2023/4/26 21:44
 * @description: 商品服务层实现类
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        return productMapper.findHotList();
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }
}
