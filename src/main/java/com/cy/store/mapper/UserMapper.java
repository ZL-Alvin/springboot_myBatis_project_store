package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * @Title: UserMapper
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/18 21:47
 * @description: 用户模块的持久层接口
 */
@Repository
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户的数据
     * @return 受影响的行数（根据返回值判断是否执行成功）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户则返回这个用户的数据，如果没有找到则返回null值
     */
    User findByUsername(@Param("username") String username);

    /**
     * 根据用户id来修改用户
     * @param uid  用户的uid
     * @param password  用户输入的新密码
     * @param modifiedUser  表示修改执行者
     * @param modifiedTime  表示修改数据的时间
     * @return  返回值为受影响的行数
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的uid
     * @return 如果找到则返回对象，如果没找到则返回null
     */
    User findByUid(Integer uid);

    /**
     * 更新用户信息
     * @param user  用户的数据
     * @return  返回值为受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * 根据用户uid修改用户头像
     * @param user 参数
     * @return  返回修改行数
     */
    Integer updateAvatarByUid(User user);
}
