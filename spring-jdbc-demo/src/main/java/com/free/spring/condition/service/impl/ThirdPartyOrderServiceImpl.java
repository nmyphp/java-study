package com.free.spring.condition.service.impl;

import com.free.spring.condition.common.ThirdPartyCondition;
import com.free.spring.condition.dao.ThirdPartyOrderDao;
import com.free.spring.jdbc.demo.dao.po.Order;
import com.free.spring.jdbc.demo.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Conditional({ThirdPartyCondition.class})
@Service
public class ThirdPartyOrderServiceImpl implements OrderService {

    @Autowired
    private ThirdPartyOrderDao thirdPartyOrderDao;

    @Override
    public List<Order> findByTid(Long tid) {
        return thirdPartyOrderDao.findByTid(tid);
    }
}
