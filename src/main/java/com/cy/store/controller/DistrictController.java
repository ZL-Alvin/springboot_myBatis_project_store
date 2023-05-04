package com.cy.store.controller;

import com.cy.store.entity.District;
import com.cy.store.service.IDistrictService;
import com.cy.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: DistrictController
 * @Author Alvin
 * @Package com.cy.store.controller
 * @Date 2023/4/25 17:03
 * @description: 省市区控制层
 */

@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;

    @PostMapping()
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(Ok, data);
    }
}
