package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Title: UserServiceTest
 * @Author Alvin
 * @Package com.cy.store.mapper.service
 * @Date 2023/4/19 20:38
 * @description: user的service层测试
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void insertTest() {
        try {
            User user = new User();
            user.setUsername("ivy");
            user.setPASSWORD("123");
            userService.reg(user);
            System.out.println("OK！");
        } catch (ServiceException e) {
            //获取类的对象，再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void loginTest() {
        User user = userService.login("Hello", "123");
        System.out.println(user);
    }

    @Test
    public void testUpdatePassword() {
        userService.changePassword(21, "timi", "123", "123456");
    }

    @Test
    public void testChangeInfo() {
        User user = new User();
        user.setPhone("1234653132");
        user.setEmail("hahah@wqc.com");
        userService.changeInfo(21, "管理员", user);
    }

    @Test
    public void testChangeAvatar() {
        User user = new User();
        user.setUid(21);
        user.setAvatar("/upload/imag/temp");
        user.setModifiedTime(new Date());
        user.setModifiedUser("花花");
        userService.changeAvatar(user);
    }
}
