package com.mrlu.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 简单de快乐
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-04-09 14:09
 */
public class MainApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        // 按任意键退出
        System.in.read(); 
    }
}
