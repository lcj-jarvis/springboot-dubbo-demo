package com.mrlu.dubbo.service.impl;

import com.mrlu.dubbo.bean.UserAddress;
import com.mrlu.dubbo.service.OrderService;
import com.mrlu.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 简单de快乐
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-04-09 13:38
 *
 *
 * 当zookeeper发送down机后，仍然可以访问到
 */
@Service
public class OrderServiceImpl implements OrderService {

    //如果服务提供者的@DubboService注解有相应的属性，下面的@DubboReference就要使用相应的属性。url除外。有url相当于dubbo直连
    //@DubboReference(interfaceClass = UserService.class,version = "1.0.0",check = true,url = "dubbo://127.0.0.1:20880")
    //@DubboReference
    ////第一个超时为接口级别的。@Method(name = "getUserAddressList",timeout = 6000)表示消费者接收getUserAddressList方法提供的服务的超时时间
    //retries = 3 表示重试次数，不包含第一次，第一次失败后重试3次，0表示不重试。如果有多个服务提供会切换多个服务重试
    //version = 1.0.0 表示使用旧版的UserServiceImpl。因为UserServiceImpl的@DubboService的版本号version配置成了1.0.0
    //version = 2.0.0 表示使用新版的UserServiceImpl2。因为UserServiceImpl2的@DubboService的版本号version配置成了2.0.0
    //version = * 表示随机匹配一个版本号
    //stub为配置本地存根 loadbalance = "random"表示使用随机的负载均衡
    @DubboReference(timeout = 3000,methods = {@Method(name = "getUserAddressList",timeout = 10000)},retries = 3,version = "*",stub = "com.mrlu.dubbo.service.impl.UserServiceStub",loadbalance = "random")
    UserService userService;

    /**
     * 初始化订单
     * @param userId
     */
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("================>"+userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }
}
