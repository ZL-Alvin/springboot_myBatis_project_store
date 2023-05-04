package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.ex.AccessDeniedException;
import com.cy.store.service.ex.CarNotFoundException;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UpdateException;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Title: CartServiceImpl
 * @Author Alvin
 * @Package com.cy.store.service.impl
 * @Date 2023/4/27 14:58
 * @description: 购物车实现类
 */
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        Cart res = cartMapper.findByUidAndPid(uid, pid);
        if (res == null) {//表示这个商品从来没有被添加到购物车中，则进行新增操作
            //创建一个cart对象
            Cart cart = new Cart();
            //补全数据：参数传递的数据
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            //价格：来自商品层中的数据
            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            cart.setCreatedUser(username);
            cart.setCreatedTime(new Date());
            cart.setModifiedUser(username);
            cart.setModifiedTime(new Date());
            Integer row = cartMapper.insert(cart);
            if (row != 1) {
                throw new InsertException("插入数据时产生的未知异常");
            }
        }else {//表示当前的商品在购物车中已经存在，则更新这条数据的num值
            Integer rows = cartMapper.updateNumByCid(res.getCid(), res.getNum() + amount, username, new Date());
            if (rows != 1) {
                throw new UpdateException("更新数据时产生未知的异常");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart res = cartMapper.findByCid(cid);
        if (res == null) {
            throw new CarNotFoundException("数据不存在");
        }
        if (!res.getUid().equals(uid)) {
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = res.getNum() + 1;
        Integer i = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (i != 1) {
            throw new UpdateException("更新数据失败");
        }
        return num;
    }

    @Override
    public Integer subNum(Integer cid, Integer uid, String username) {
        Cart res = cartMapper.findByCid(cid);
        if (res == null) {
            throw new CarNotFoundException("数据不存在");
        }
        if (!res.getUid().equals(uid)) {
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = res.getNum() - 1;
        Integer i = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (i != 1) {
            throw new UpdateException("更新数据失败");
        }
        return num;
    }

    @Override
    public void deleteProduct(Integer cid) {
        Cart res = cartMapper.findByCid(cid);
        if (res == null) {
            throw new CarNotFoundException("商品数据不存在");
        }
        cartMapper.deleteByCid(cid);
    }

    @Override
    public List<CartVO> getVOByCids(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCids(cids);
        /**
         for (CartVO cart : list) {
         if (!cart.getUid().equals(uid)) {
         list.remove(cart);
         }
         }
         */
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()) {
            CartVO cart = it.next();
            if (!cart.getUid().equals(uid)) {
                it.remove();
            }
        }
        return list;
    }
}
