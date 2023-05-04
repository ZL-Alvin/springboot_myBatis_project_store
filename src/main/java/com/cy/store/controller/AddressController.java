package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.utils.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: AddressController
 * @Author Alvin
 * @Package com.cy.store.controller
 * @Date 2023/4/25 15:06
 * @description: 收货地址的控制层
 */
@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController{
    @Autowired
    private IAddressService addressService;

    @PostMapping("/addNewAddress")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
        addressService.addNewAddress(getuidFromSession(session), getUsernameFromSession(session), address);
        return new JsonResult<>(Ok);
    }

    @GetMapping()
    public JsonResult<List<Address>> getAddressByUid(HttpSession session) {
        Integer uid = getuidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(Ok, data);
    }

    @GetMapping("/setDefault/{aid}")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session) {
        addressService.setDefault(aid, getuidFromSession(session));
        return new JsonResult<>(Ok);
    }

    @PostMapping("/delete/{aid}")
    public JsonResult<Void> deleteAddress(HttpSession session, @PathVariable("aid") Integer aid) {
        addressService.delete(aid, getuidFromSession(session));
        return new JsonResult<>(Ok);
    }

    @GetMapping("/update/{aid}")
    public JsonResult<Void> getAddressByAid(@PathVariable("aid") Integer aid, Model model) {
        Address address = addressService.findByAid(aid);
        model.addAttribute("address", address);
        return new JsonResult<>(Ok);
    }

    @PostMapping("/update")
    public JsonResult<Void> updateAddress(Address address) {
        addressService.updateAddress(address);
        return new JsonResult<>(Ok);
    }
}
