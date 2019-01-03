package com.free.spring.jdbc.demo.controller;

import com.free.spring.jdbc.demo.dao.po.Order;
import com.free.spring.jdbc.demo.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{tid}")
    @ResponseBody
    public List<Order> findByTid(@PathVariable("tid") Long tid) {
        return orderService.findByTid(tid);
    }
}
