package com.cy.store.service.ex;

/**
 * @Title: DeleteException
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/26 15:26
 * @description: 删除收货地址时异常
 */
public class DeleteException extends ServiceException{
    public DeleteException() {
        super();
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
