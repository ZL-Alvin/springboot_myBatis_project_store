package com.cy.store.service;

import com.cy.store.mapper.CartMapper;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Title: ICartService
 * @Author Alvin
 * @Package com.cy.store.service
 * @Date 2023/4/27 14:52
 * @description: 购物车服务层接口
 */
public interface ICartService {
    /**
     * 将商品添加到购物车中
     * @param uid 用户id
     * @param pid 商品id
     * @param amount 商品数量
     * @param username 用户名
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /**
     * 得到购物车显示的数据
     * @param uid 用户id
     * @return 返回信息
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * 增加用户的购物车数据的数量
     * @param cid 产品cid
     * @param uid 用户uid
     * @param username 用户名
     * @return 增加成功后的数量
     */
    Integer addNum(Integer cid, Integer uid, String username);

    /**
     * 减少用户购物车数据的数量
     * @param cid 产品cid
     * @param uid 用户uid
     * @param username 用户名
     * @return 减少成功后的数量
     */
    Integer subNum(Integer cid, Integer uid, String username);

    /**
     * 删除购物车商品
     * @param cid 商品cid
     */
    void deleteProduct(Integer cid);

    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param uid 当前登录的用户的id
     * @param cids 若干个购物车数据id
     * @return 匹配的购物车数据详情的列表
     */
    List<CartVO> getVOByCids(Integer uid, Integer[] cids);
}
