package com.mrlu.dubbo.service;

import com.mrlu.dubbo.bean.Person;

/**
 * @author 简单de快乐
 * @date 2021-06-23 1:28
 */
public interface PersonService {

    /**
     * 解决直连没有接口工程的弊端
     * @return
     */
    Person getPerson();
}
