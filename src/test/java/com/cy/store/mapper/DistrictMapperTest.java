package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Title: DistrictMapperTest
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/25 16:19
 * @description: 地区模块dao层测试
 */
@SpringBootTest
public class DistrictMapperTest {
    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void findByParentTest() {
        List<District> list = districtMapper.findByParent("210100");
        for (District d : list) {
            System.out.println(d);
        }
    }

    @Test
    public void findNameByCodeTest() {
        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);
    }
}
