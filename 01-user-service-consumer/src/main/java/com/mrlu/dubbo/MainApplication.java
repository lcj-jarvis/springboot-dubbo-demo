package com.mrlu.dubbo;


import com.mrlu.dubbo.service.impl.OrderServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 简单de快乐
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-04-09 14:09
 */
public class MainApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        OrderServiceImpl orderServiceImpl = context.getBean("orderServiceImpl", OrderServiceImpl.class);
        orderServiceImpl.initOrder("1");
        System.out.println("调用成功");
        // 按任意键退出
        System.in.read(); 
    }
}
