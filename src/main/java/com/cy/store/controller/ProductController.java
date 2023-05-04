package com.cy.store.controller;

import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import com.cy.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Title: ProductController
 * @Author Alvin
 * @Package com.cy.store.controller
 * @Date 2023/4/26 21:49
 * @description: 商品的控制层
 */

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController{
    @Autowired
    private IProductService productService;

    @GetMapping("/hotList")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JsonResult<>(Ok, data);
    }

    @GetMapping("/details/{id}")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        Product data = productService.findById(id);
        return new JsonResult<>(Ok, data);
    }
}
