package com.mrlu.dubbo.service.impl;

import com.mrlu.dubbo.bean.Person;
import com.mrlu.dubbo.service.PersonService;

import javax.jnlp.PersistenceService;

/**
 * @author 简单de快乐
 * @date 2021-06-23 1:38
 */
public class PersonServiceImpl implements PersonService {
    @Override
    public Person getPerson() {
        return new Person("jack", 18);
    }
}
