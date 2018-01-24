package com.free.spring.jdbc.demo;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2017/12/19
 */
@Setter
@Getter
public class OrderPromotionDetail {
    private Long tid;
    private String promotionName;
    private String discountFee;
}
