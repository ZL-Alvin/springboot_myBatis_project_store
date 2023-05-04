package com.cy.store.service;


import com.cy.store.entity.District;

import java.util.List;

/**
 * @Title: IDistrictService
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/25 16:26
 * @description: 省市区服务层接口
 */
public interface IDistrictService {

    /**
     * 根据父代号来查询区域信息（省市区）
     * @param parent 父代码
     * @return 多个区域信息
     */
    List<District> getByParent(String parent);

    /**
     * 根据代码查询省市区的名称
     * @param code 代码
     * @return 省市区名称
     */
    String getNameByCode(String code);
}
