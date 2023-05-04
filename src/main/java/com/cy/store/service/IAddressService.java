package com.cy.store.service;

import com.cy.store.entity.Address;

import java.util.List;

/**
 * @Title: IAddressService
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/25 14:22
 * @description: 收货地址业务层接口
 */

public interface IAddressService {
    /**
     * 新增收货地址
     * @param uid 用户id
     * @param username 修改人
     * @param address 地址信息
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * 根据用户id获取所有地址信息
     * @param uid 用户的id
     * @return 该用户的所有的地址
     */
    List<Address> getByUid(Integer uid);

    /**
     * 修改某个用户的某条收货地址数据为默认地址
     * @param aid 收货地址的id
     * @param uid 用户的id
     */
    void setDefault(Integer aid, Integer uid);

    /**
     * 删除用户选中的收货资源地址数据
     * @param aid 收货地址id
     * @param uid 用户id
     */
    void delete(Integer aid, Integer uid);

    /**
     * 修改地址信息
     * @param address 地址信息
     */
    void updateAddress(Address address);

    /**
     * 根据aid查询地址
     * @param aid 地址的aid
     * @return 返回查询到的地址
     */
    Address findByAid(Integer aid);

    /**
     * 根据收货地址数据的id，查询收货地址详情
     * @param aid 收货地址id
     * @param uid 归属的用户id
     * @return 匹配的收货地址详情
     */
    Address getByAid(Integer aid, Integer uid);
}
