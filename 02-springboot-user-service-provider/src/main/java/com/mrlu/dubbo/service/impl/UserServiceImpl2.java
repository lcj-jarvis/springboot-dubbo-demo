package com.mrlu.dubbo.service.impl;

import com.mrlu.dubbo.bean.UserAddress;
import com.mrlu.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @DubboService注解暴露服务
 */
//@DubboService(interfaceClass = UserService.class,version = "1.0.0")
//第一个超时为接口级别的。@Method(name = "getUserAddressList",timeout = 6000)表示服务者提供getUserAddressList方法的超时时间
@DubboService(timeout = 5000,methods = {@Method(name = "getUserAddressList",timeout = 6000)},version = "2.0.0")
@Service
public class UserServiceImpl2 implements UserService {

	/**
	 * 测试多版本。当前的为新版本
	 * @param userId
	 * @return
	 */
	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl.....new...");
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Arrays.asList(address1,address2);
	}
}
