package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.utils.JsonResult;
import com.cy.store.vo.CartVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: CartController
 * @Author Alvin
 * @Package com.cy.store.controller
 * @Date 2023/4/27 15:44
 * @description: 购物车控制层
 */
@RestController
@RequestMapping("/carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @GetMapping("/addToCarts")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
        cartService.addToCart(getuidFromSession(session), pid, amount, getUsernameFromSession(session));
        return new JsonResult<>(Ok);
    }

    @GetMapping("")
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        List<CartVO> data = cartService.getVOByUid(getuidFromSession(session));
        return new JsonResult<>(Ok, data);
    }

    @PostMapping("/{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer data = cartService.addNum(cid, getuidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(Ok, data);
    }

    @PostMapping("/{cid}/num/sub")
    public JsonResult<Integer> subNum(@PathVariable("cid") Integer cid, HttpSession session) {
        Integer data = cartService.subNum(cid, getuidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(Ok, data);
    }

    @PostMapping("/delete/{cid}")
    public JsonResult<Void> deleteCart(@PathVariable("cid") Integer cid) {
        cartService.deleteProduct(cid);
        return new JsonResult<>(Ok);
    }

    @GetMapping("/list")
    public JsonResult<List<CartVO>> getVOByCids(Integer[] cids, HttpSession session) {
        // 从Session中获取uid
        Integer uid = getuidFromSession(session);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByCids(uid, cids);
        // 返回成功与数据
        return new JsonResult<>(Ok, data);
    }
}
