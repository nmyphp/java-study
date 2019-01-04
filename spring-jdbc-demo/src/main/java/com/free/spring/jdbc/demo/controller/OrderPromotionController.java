package com.free.spring.jdbc.demo.controller;

import com.free.spring.jdbc.demo.dao.po.OrderPromotion;
import com.free.spring.jdbc.demo.service.OrderPromotionService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenlongjs
 * @date: 2017/12/19
 */

@RestController
@RequestMapping("/promotion")
public class OrderPromotionController {

    @Autowired
    private OrderPromotionService promotionService;

    @GetMapping("/{tid}")
    @ResponseBody
    public List<OrderPromotion> query(@PathVariable("tid") Long tid) {
        try {
            return promotionService.findByTid(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
