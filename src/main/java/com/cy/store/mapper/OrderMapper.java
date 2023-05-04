package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import org.springframework.stereotype.Repository;

/**
 * @Title: OrderMapper
 * @Author Alvin
 * @Package com.cy.store.mapper
 * @Date 2023/4/30 19:07
 * @description: 订单dao层
 */
@Repository
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);
}
