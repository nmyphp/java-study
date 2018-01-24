package com.free.spring.jdbc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2017/12/19
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OrderPromotionDetailDao orderPromotionDetaildao;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderPromotionDetail> query (Long tid){
        try {
            return orderPromotionDetaildao.findByTid(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
