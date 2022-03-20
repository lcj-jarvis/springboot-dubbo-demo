package com.mrlu.dubbo.controller;

import com.mrlu.dubbo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 简单de快乐
 * @date 2021-06-22 22:53
 *
 * 弊端：这种直连的方式，会暴露服务提供方的细节
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService ;

    @GetMapping("/hello")
    public ModelAndView sayHello() {
        //调用接口服务
        String hello = studentService.sayHello();
        System.out.println("========================>" + hello);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", hello);
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
