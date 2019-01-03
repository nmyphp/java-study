package com.free.spring.jdbc.demo.service.impl;

import com.free.spring.jdbc.demo.common.DefaultCondition;
import com.free.spring.jdbc.demo.dao.OrderDao;
import com.free.spring.jdbc.demo.dao.po.Order;
import com.free.spring.jdbc.demo.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Conditional(DefaultCondition.class)
@Service
public class DefaultOrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findByTid(Long tid) {
        return orderDao.findByTid(tid);
    }
}
