package com.cy.store.service.ex;

/**
 * @Title: ProductNotFound
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/26 22:09
 * @description: 找不到商品的异常
 */
public class ProductNotFound extends ServiceException{
    public ProductNotFound() {
        super();
    }

    public ProductNotFound(String message) {
        super(message);
    }

    public ProductNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFound(Throwable cause) {
        super(cause);
    }

    protected ProductNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
