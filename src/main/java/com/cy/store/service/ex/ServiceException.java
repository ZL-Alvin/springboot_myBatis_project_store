package com.cy.store.service.ex;

/**
 * @Title: ServiceException
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/19 20:18
 * @description: 业务层异常的基类
 */
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
