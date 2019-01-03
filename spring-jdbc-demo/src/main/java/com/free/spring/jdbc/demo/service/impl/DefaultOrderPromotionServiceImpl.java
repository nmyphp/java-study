package com.free.spring.jdbc.demo.service.impl;

import com.free.spring.jdbc.demo.common.DefaultCondition;
import com.free.spring.jdbc.demo.dao.OrderPromotionDao;
import com.free.spring.jdbc.demo.dao.po.OrderPromotion;
import com.free.spring.jdbc.demo.service.OrderPromotionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * 默认实现.
 */
@Conditional(DefaultCondition.class)
@Service
public class DefaultOrderPromotionServiceImpl implements OrderPromotionService {

    @Autowired
    private OrderPromotionDao promotionDao;

    @Override
    public List<OrderPromotion> findByTid(Long tid) {
        return promotionDao.findByTid(tid);
    }
}
