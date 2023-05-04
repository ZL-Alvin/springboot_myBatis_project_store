package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Title: AddressMapperTest
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/25 14:01
 * @description: 收货地址dao层测试
 */
@SpringBootTest
public class AddressMapperTest {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(21);
        address.setPhone("12345678903212");
        address.setName("Alina");
        addressMapper.insert(address);
    }

    @Test
    public void countByUid() {
        System.out.println(addressMapper.countByUid(21));
    }

    @Test
    public void findByUid() {
        System.out.println(addressMapper.findByUid(21));
    }

    @Test
    public void updateNonDefault() {
        addressMapper.updateNonDefault(21);
    }

    @Test
    public void updateDefaultByAid() {
        addressMapper.updateDefaultByAid(6);
    }

    @Test
    public void findByAid() {
        System.out.println(addressMapper.findByAid(6));
    }

    @Test
    public void deleteByAid() {
        addressMapper.deleteByAid(3);
    }

    @Test
    public void findLastModified() {
        System.out.println(addressMapper.findLastModified(21));
    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address();
        address.setAid(9);
        address.setName("Tony");
        addressMapper.updateAddressByAid(address);
    }
}
