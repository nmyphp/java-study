package com.free.spring.jdbc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2017/12/19
 */

@Repository
public class OrderPromotionDetailDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<OrderPromotionDetail> findByTid(final Long tid) {
        String sql = "select tid,promotion_name,discount_fee from order_promotion_detail where partner_id=9 and tid = ?";

        return jdbcTemplate.query(sql, new RowMapper<OrderPromotionDetail>() {
            @Override
            public OrderPromotionDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                OrderPromotionDetail promotion = new OrderPromotionDetail();
                promotion.setTid(resultSet.getLong(1));
                promotion.setPromotionName(resultSet.getString(2));
                promotion.setDiscountFee(resultSet.getString(3));
                return promotion;
            }
        }, tid);
    }


}
