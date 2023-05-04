package com.cy.store.service.ex;

/**
 * @Title: UsernameDuplicatedException
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/19 20:22
 * @description: 用户名被占用的异常
 */
public class UsernameDuplicatedException extends ServiceException{
    public UsernameDuplicatedException() {
        super();
    }

    public UsernameDuplicatedException(String message) {
        super(message);
    }

    public UsernameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
