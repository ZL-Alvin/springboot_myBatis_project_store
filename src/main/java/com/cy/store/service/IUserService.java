package com.cy.store.service;

import com.cy.store.entity.User;

/**
 * @Title: IUserService
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/19 20:25
 * @description: 用户模块业务层接口
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user
     */
    void reg(User user);

    /**
     * 用户登录功能
     * @param username
     * @param password
     * @return 当前匹配的用户数据，如果没有则返回null
     */
    User login(String username, String password);

    /**
     * 修改密码功能
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * 更新用户数据的操作
     * @param uid 用户的id
     * @param username 用户的名称
     * @param user 用户对象的数据
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 获得登录对象的信息
     * @param uid 用户id
     * @return 返回信息
     */
    User getByUid(Integer uid);

    /**
     * 修改用户的头像
     * @param user 用户信息
     */
    void changeAvatar(User user);
}
