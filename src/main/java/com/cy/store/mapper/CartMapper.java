package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Title: CartMapper
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/27 14:01
 * @description: 购物车dao层接口
 */
@Repository
public interface CartMapper {
    /**
     * 插入购物车数据
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 更新购物车某件商品数量
     * @param cid 购物车数据cid
     * @param num 更新的数量
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 受影响行数
     */
    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户的id和商品的id来查询购物车中的数据
     * @param uid 用户id
     * @param pid 商品id
     * @return 返回商品数据
     */
    Cart findByUidAndPid(Integer uid, Integer pid);

    /**
     * 查找要显示的数据
     * @param uid 用户id
     * @return 两表联查信息
     */
    List<CartVO> findVOByUid(Integer uid);

    /**
     * 根据cid查找商品
     * @param cid 商品cid
     * @return 返回商品信息
     */
    Cart findByCid(Integer cid);

    /**
     * 删除商品
     * @param cid 商品cid
     * @return 受影响的行数
     */
    Integer deleteByCid(Integer cid);

    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param cids 若干个购物车数据id
     * @return 匹配的购物车数据详情的列表
     */
    List<CartVO> findVOByCids(Integer[] cids);
}
