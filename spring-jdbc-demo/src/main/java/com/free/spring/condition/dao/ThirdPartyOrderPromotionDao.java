package com.free.spring.condition.dao;

import com.free.spring.jdbc.demo.dao.po.OrderPromotion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ThirdPartyOrderPromotionDao {

    public static final String SQL_FIND_BY_TID = "select tid,promotion_name,discount_fee from order_promotion_3party "
        + "where tid = ? and partner_id=9";

    @Autowired
    @Qualifier("secondJdbcTemplate")
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
