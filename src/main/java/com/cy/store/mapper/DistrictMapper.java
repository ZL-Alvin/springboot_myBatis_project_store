package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: DistrictMapper
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/25 16:15
 * @description: 地区信息dao层
 */
@Repository
public interface DistrictMapper {
    /**
     * 根据父代号查询区域信息
     * @param parent 父代号
     * @return 某个父区域下的所有区域列表
     */
    List<District> findByParent(String parent);

    /**
     * 根据code查询省市区的名称
     * @param code 代码
     * @return 返回省市区名称
     */
    String findNameByCode(String code);
}
