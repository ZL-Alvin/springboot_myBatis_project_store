package com.cy.store.service.ex;

/**
 * @Title: AddressCountLimitException
 * @Author Alvin
 * @Package com.cy.store.service.ex
 * @Date 2023/4/25 14:21
 * @description: 收货地址总数超出限制（20条）
 */
public class AddressCountLimitException  extends ServiceException{
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
