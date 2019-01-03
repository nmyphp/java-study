package com.free.spring.jdbc.demo.dao.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2017/12/19
 */
@Setter
@Getter
public class OrderPromotion {
    private Long tid;
    private String promotionName;
    private String discountFee;
}
