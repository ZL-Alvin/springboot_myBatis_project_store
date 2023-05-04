package com.cy.store.entity;

/**
 * @Title: District
 * @Author Alvin
 * @Package com.cy.store.entity
 * @Date 2023/4/25 16:03
 * @description: 省市区的数据实体类
 */
public class District {
    private Integer id;
    private String parent;
    private String code;
    private String name;

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
