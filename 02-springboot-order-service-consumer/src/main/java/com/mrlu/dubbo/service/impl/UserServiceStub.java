package com.mrlu.dubbo.service.impl;

import com.mrlu.dubbo.bean.UserAddress;
import com.mrlu.dubbo.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 简单de快乐
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-04-09 23:08
 *
 * 测试本地存根。一般本地存根都是放在接口工程的
 */
public class UserServiceStub implements UserService {

    private final UserService userService;

    /**
     * Dubbo传入UserService的远程代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    /**
     * 在调用远程方法是先验证
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("本地存根.....");
        if(StringUtils.hasText(userId)){
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
