package com.free.spring.jdbc.demo.service;

import com.free.spring.jdbc.demo.dao.po.Order;
import java.util.List;

public interface OrderService {

    /**
     * 通过tid查询订单信息
     * @param tid 订单主键
     */
    List<Order> findByTid(Long tid);
}
