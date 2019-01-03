package com.free.spring.jdbc.demo.dao;

import com.free.spring.jdbc.demo.dao.po.OrderPromotion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2017/12/19
 */

@Repository
public class OrderPromotionDao {

    private final String SQL_FIND_BY_TID = "select tid,promotion_name,discount_fee from order_promotion where tid = ?";

    @Autowired
    @Qualifier("firstJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<OrderPromotion> findByTid(final Long tid) {

        return jdbcTemplate.query(SQL_FIND_BY_TID, (resultSet, index) -> {
            OrderPromotion promotion = new OrderPromotion();
            promotion.setTid(resultSet.getLong(1));
            promotion.setPromotionName(resultSet.getString(2));
            promotion.setDiscountFee(resultSet.getString(3));
            return promotion;
        }, tid);
    }


}
