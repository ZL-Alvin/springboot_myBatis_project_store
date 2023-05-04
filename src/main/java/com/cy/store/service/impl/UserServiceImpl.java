package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @Title: UserServiceImpl
 * @Author Alvin
 * @Package com.cy.store.service.impl
 * @Date 2023/4/19 20:27
 * @description: 用户模块业务层的实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //获取传递过来的username
        String username = user.getUsername();
        //判断用户是否被注册
        User result = userMapper.findByUsername(username);
        //判断结果集是否不为null，若不为null则抛出异常
        if (result != null) {
            //抛出异常
            throw  new UsernameDuplicatedException("用户名被占用");
        }

        /*
        密码加密处理：md5算法形式
        串 + password + 串  ---> md5算法进行加密，连续加载三次
        盐值 + password + 盐值 --------盐值就是一个随机的字符串
        */
        String oldPassword = user.getPASSWORD();
        //获取盐值（随机生成一个盐值）
        String salt = UUID.randomUUID().toString().toUpperCase();
        //将密码和盐值作为一个整体进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);
        //讲加密之后的密码重新设置到user对象中
        user.setPASSWORD(md5Password);

        //补全数据：盐值的记录
        user.setSalt(salt);
        //补全数据：is_delete设置成0
        user.setIsDelete(0);
        //补全数据：4个日志
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //执行注册业务功能(row == 1)
        Integer row = userMapper.insert(user);
        if (row != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }

    }

    @Override
    public User login(String username, String password) {
        //根据用户名称查询用户数据是否存在，如果不存在，则抛出异常
        User result = userMapper.findByUsername(username);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在！");
        }
        //检测用户的密码是否匹配
        //1、先获取到数据库中的加密之后的密码
        String oldPassword = result.getPASSWORD();
        //2、和用户传递过来的密码进行比较
        //2.1、先获取盐值：上一次注册时自动生成的盐值
        String salt = result.getSalt();
        //2.2、将用户的密码按照相同的md5算法规则进行加密
        String newMd5Password = getMD5Password(password, salt);
        //将密码进行比较
        if (!oldPassword.equals(newMd5Password)) {
            throw new PasswordNotMatchException("密码错误！");
        }
        return result;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }
        //原始密码与数据库中的密码进行比较
        String oldMd5Password = getMD5Password(oldPassword, result.getSalt());
        if (!result.getPASSWORD().equals(oldMd5Password)) {
            throw new PasswordNotMatchException("密码错误");
        }
        //将新密码设置到数据库中，将新的密码进行加密再去更新
        String newMd5Password = getMD5Password(newPassword, result.getSalt());
        Integer i = userMapper.updatePasswordByUid(uid, newMd5Password, username, new Date());
        if (i != 1) {
            throw new UpdateException("更新数据时产生未知的异常");
        }
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete()==1) {
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1) {
            throw new UpdateException("更新数据时产生的未知异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }
        return result;
    }

    @Override
    public void changeAvatar(User user) {
        //查询当前用户信息是否存在
        User result = userMapper.findByUid(user.getUid());
        if (user == null || result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(user);
        if (rows != 1) {
            throw new UpdateException("更新用户头像产生未知的异常");
        }
    }

    /**
     * 定义一个md5算法的加密处理
     * @param password
     * @param salt
     * @return
     */
    public String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; ++i) {
            //md5加密算法方法调用
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        //返回加密之后的密码
        return password;
    }
}
