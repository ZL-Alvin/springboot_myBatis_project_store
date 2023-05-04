package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Title: UserMapperTest
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/19 19:00
 * @description: UserMapper测试
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest() {
        User user = new User();
        user.setUsername("Alvin");
        user.setPASSWORD("123456");
        System.out.println(userMapper.insert(user));
    }

    @Test
    public void findByUsernameTest() {
        System.out.println(userMapper.findByUsername("Alvin"));
    }

    @Test
    public void testUpdatePasswordByUid() {
        userMapper.updatePasswordByUid(12, "123456", "系统管理员", new Date());
    }

    @Test
    public void testFindByuId() {
        System.out.println(userMapper.findByUid(12));
    }

    @Test
    public void testUpdateInfoByUid() {
        User user = new User();
        user.setUid(21);
        user.setPhone("12345678903212");
        user.setEmail("2331432412@qq.com");
        user.setGender(1);
        Integer i = userMapper.updateInfoByUid(user);
        System.out.println(i);
    }

    @Test
    public void testUpdateAvatarByUid() {
        User user = new User();
        user.setUid(21);
        user.setAvatar("/haha/heihei/hehe");
        user.setModifiedTime(new Date());
        user.setModifiedUser("系统管理员");
        Integer i = userMapper.updateAvatarByUid(user);
        System.out.println(i);
    }

}
