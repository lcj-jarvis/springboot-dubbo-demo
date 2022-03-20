package com.mrlu.dubbo.service.impl;

import com.mrlu.dubbo.service.StudentService;

/**
 * @author 简单de快乐
 * @date 2021-06-22 22:42
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public String sayHello() {
        return "hello dubbo";
    }
}
