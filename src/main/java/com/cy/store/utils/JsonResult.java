package com.cy.store.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title: JsonResult
 * @Author Alvin
 * @Package com.cy.store.utils
 * @Date 2023/4/19 21:11
 * @description: Json格式的数据进行响应
 */
@Data
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;
    //描述信息
    private String message;
    //数据
    private E data;

    public JsonResult() {}

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
}
