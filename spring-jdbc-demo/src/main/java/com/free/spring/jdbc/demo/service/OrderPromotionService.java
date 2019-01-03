package com.free.spring.jdbc.demo.service;

import com.free.spring.jdbc.demo.dao.po.OrderPromotion;
import java.util.List;

public interface OrderPromotionService {

    /**
     * 通过tid获取促销详情.
     * @param tid 订单唯一标识
     */
    List<OrderPromotion> findByTid(Long tid);
}
