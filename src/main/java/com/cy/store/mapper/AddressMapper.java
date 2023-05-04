package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: AddressMapper
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/25 13:42
 * @description: 收货地址持久层的接口
 */
@Repository
public interface AddressMapper {

    /**
     * 插入用户的收货地址数据
     * @param address 收货地址数据统计
     * @return 受影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的id统计收货地址的数量
     * @param uid 用户的id
     * @return 当前用户的收货地址总数
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户的id查询用户的收货地址数据
     * @param uid 用户id
     * @return 收货地址数据
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据Aid查询收货地址
     * @param aid 收货地址Aid
     * @return 收货地址数据
     */
    Address findByAid(Integer aid);

    /**
     * 根据用户的uid修改收货地址为非默认
     * @param uid 用户uid
     * @return 受影响行数
     */
    Integer updateNonDefault(Integer uid);

    /**
     * 根据收货地址Aid来修改用户的收货地址为默认
     * @param aid 地址的Aid
     * @return 受影响的行数
     */
    Integer updateDefaultByAid(Integer aid);

    /**
     * 根据收货地址的id删除收货地址
     * @param aid 收货地址aid
     * @return 受影响行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据当前用户的uid查询最后一次被修改的收货地址数据
     * @param uid 用户的id
     * @return 收货地址数据
     */
    Address findLastModified(Integer uid);

    /**
     * 根据aid进行收货地址的修改
     * @param address 收货地址的信息
     * @return 返回受影响的行数
     */
    Integer updateAddressByAid(Address address);


}
