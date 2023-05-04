package com.cy.store.service.ex;

/**
 * @Title: UpdateException
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/24 10:37
 * @description: 用户在更新数据时产生的未知的异常
 */
public class UpdateException extends ServiceException{
    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
