package com.cy.store.service;

import com.cy.store.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Title: DistrictServiceTest
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/25 16:30
 * @description: 省市区服务层测试
 */
@SpringBootTest
public class DistrictServiceTest {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent() {
        //86表示中国，所有省的父代号都是86
        List<District> list = districtService.getByParent("86");
        for (District d : list) {
            System.err.println(d);
        }
    }

    @Test
    public void getNameByCode() {
        System.out.println(districtService.getNameByCode("610000"));
    }
}
