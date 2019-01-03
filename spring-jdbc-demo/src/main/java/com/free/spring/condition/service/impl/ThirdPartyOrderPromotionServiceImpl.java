package com.free.spring.condition.service.impl;

import com.free.spring.condition.common.ThirdPartyCondition;
import com.free.spring.condition.dao.ThirdPartyOrderPromotionDao;
import com.free.spring.jdbc.demo.dao.po.OrderPromotion;
import com.free.spring.jdbc.demo.service.OrderPromotionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Conditional(ThirdPartyCondition.class)
@Service
public class ThirdPartyOrderPromotionServiceImpl implements OrderPromotionService {

    @Autowired
    private ThirdPartyOrderPromotionDao thirdPartyOrderPromotionDao;

    @Override
    public List<OrderPromotion> findByTid(Long tid) {
        return thirdPartyOrderPromotionDao.findByTid(tid);
    }
}
