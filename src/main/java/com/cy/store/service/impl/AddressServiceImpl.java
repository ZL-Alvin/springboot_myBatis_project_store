package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Title: AddressServiceImpl
 * @Author Alvin
 * @Package com.cy.store.service.impl
 * @Date 2023/4/25 14:30
 * @description: 新增收货地址的实现类
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IDistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        // 调用收货地址统计的方法
        Integer count = addressMapper.countByUid(uid);
        if (count > maxCount) {
            throw new AddressCountLimitException("用户收货地址超出上限");
        }

        //对address中的数据进行补全，省市区
        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String areaName = districtService.getNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        //uid、IsDefault
        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;  //1表示默认，0表示不是默认
        address.setIsDefault(isDefault);

        //补全四项日志
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());
        address.setCreatedTime(new Date());

        //插入收货地址
        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("插入用户的收货地址产生未知的异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        return addressMapper.findByUid(uid);
    }

    @Override
    public void setDefault(Integer aid, Integer uid) {
        Address result = addressMapper.findByAid(aid);
        if (result == null) {
            throw new AddressNotFoundException("收货地址不存在");
        }
        //检测当前获取到的收货地址数据的归属
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("非法数据访问");
        }
        //先将所有收货地址设置为非默认
        Integer rows = addressMapper.updateNonDefault(uid);
        if (rows < 1) {
            throw new UpdateException("更新数据时产生未知的异常");
        }
        //将用户选中的某条地址设置为默认收货地址
        Integer row = addressMapper.updateDefaultByAid(aid);
        if (row != 1) {
            throw new UpdateException("更新时产生未知的异常");
        }
    }

    @Override
    public void delete(Integer aid, Integer uid) {
        Address result = addressMapper.findByAid(aid);
        if (result == null) {
            throw new AddressNotFoundException("收货地址不存在");
        }
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = addressMapper.deleteByAid(aid);
        if(rows != 1) {
            throw new DeleteException("删除数据时产生未知的异常");
        }
        if (result.getIsDefault() == 1) {
            Address lastModified = addressMapper.findLastModified(uid);
            if (lastModified == null) {
                throw new AddressNotFoundException("收货地址不存在");
            }
            setDefault(lastModified.getAid(), uid);
        }
    }

    @Override
    public void updateAddress(Address address) {
        Address result = addressMapper.findByAid(address.getAid());
        if (result == null) {
            throw new AddressNotFoundException("收货地址不存在");
        }
        Integer rows = addressMapper.updateAddressByAid(address);
        if (rows != 1) {
            throw new UpdateException("更新地址时产生未知的异常");
        }
    }

    @Override
    public Address findByAid(Integer aid) {
        return addressMapper.findByAid(aid);
    }

    @Override
    public Address getByAid(Integer aid, Integer uid) {
        // 根据收货地址数据id，查询收货地址详情
        Address address = addressMapper.findByAid(aid);

        if (address == null) {
            throw new AddressNotFoundException("尝试访问的收货地址数据不存在");
        }
        if (!address.getUid().equals(uid)) {
            throw new AccessDeniedException("非法访问");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setCreatedUser(null);
        address.setCreatedTime(null);
        address.setModifiedUser(null);
        address.setModifiedTime(null);
        return address;
    }
}
