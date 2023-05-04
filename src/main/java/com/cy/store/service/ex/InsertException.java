package com.cy.store.service.ex;

/**
 * @Title: InsertException
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/19 20:24
 * @description: 数据插入过程中所产生的异常
 */
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
