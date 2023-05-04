package com.cy.store.service;

import com.cy.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Title: AddressServiceTest
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/25 14:53
 * @description: 收货地址服务层测试
 */
@SpringBootTest
public class AddressServiceTest {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddressTest() {
        Address address = new Address();
        address.setPhone("4001234567");
        address.setName("jimmy");
        addressService.addNewAddress(21, "timi", address);
    }

    @Test
    public void findByUid() {
        System.out.println(addressService.getByUid(21));
    }

    @Test
    public void setDefault() {
        addressService.setDefault(7, 21);
    }

    @Test
    public void deleteAddress() {
        addressService.delete(1, 21);
    }

    @Test
    public void updateAddress() {
        Address address = new Address();
        address.setAid(9);
        address.setName("baby");
        addressService.updateAddress(address);
    }
}
