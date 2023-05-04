package com.cy.store.service.ex;

/**
 * @Title: CarNotFoundException
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/27 20:04
 * @description: 商品找不到异常
 */
public class CarNotFoundException extends ServiceException{
    public CarNotFoundException() {
        super();
    }

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CarNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
