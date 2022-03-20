package com.mrlu.dubbo.controller;

import com.mrlu.dubbo.bean.UserAddress;
import com.mrlu.dubbo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 简单de快乐
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-04-09 16:37
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/initOrder/{id}")
    @ResponseBody
    public List<UserAddress> initOrder(@PathVariable("id")String id){
        return orderService.initOrder(id);
    }
}
