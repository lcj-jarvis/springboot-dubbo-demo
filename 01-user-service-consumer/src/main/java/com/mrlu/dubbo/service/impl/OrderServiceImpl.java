package com.mrlu.dubbo.service.impl;

import com.mrlu.dubbo.bean.UserAddress;
import com.mrlu.dubbo.service.OrderService;
import com.mrlu.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 简单de快乐
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-04-09 13:38
 *
 * 测试前提：
 * 开启zookeeper的服务和dubbo的监控中心的服务。
 *  运行 D:\软件\zookeeper-3.4.11\bin\zkServer.cmd（双击）
 *  运行：D:\入门微服务\Dubbo\自己做的笔记\dubbo监控中心的jar包
 *       cmd --》 java -jar jar包全名加.jar后缀
 *       看到Dos窗口也会显示Tocmat运行在，7001
 *       进入：localhost:7001 输入root root（jar里的application.properties配置的账号和密码）
 *       就可以登录到注册中心
 *
 * 使用dubbo改造项目
 * 1、将服务提供者注册到注册中心（暴露服务）
 *    （1）导入dubbo的依赖和操作zookeeper的客户端的依赖（curator）
 *    （2）配置服务提供者
 *
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 *
 * 测试步骤：
 * （1）开启服务提供者的服务，运行对应的MainApplication
 * （2）开启消费者的消费，运行对应的MainApplication
 *
 * 整合监控中心的主监控界面。
 * （1）进入
 *      D:\入门微服务\Dubbo\自己做的笔记\dubbo监控中心
 *      \incubator-dubbo-ops-master\dubbo-monitor-simple\src\main\resources\conf
 *      里面的dubbo.properties配置文件。
 *      修改dubbo注册中心的地址
 *      dubbo.registry.address=zookeeper://127.0.0.1:2181
 *      #设置Jetty容器的监听地址，类似于Tomcat的8080端口，这里设置为8100，避免冲突
 *      dubbo.jetty.port=8100
 * （2）  在该
 *      D:\入门微服务\Dubbo\自己做的笔记\dubbo监控中心
 *       \incubator-dubbo-ops-master\dubbo-monitor-simple\src\下运行mvn package打包该项目
 * （3）在生产者和消费者的配置文件中，加入
 *        <--配置监控中心 第一种方式-->
 *        <--<dubbo:monitor protocol="registry"></dubbo:monitor>-->
 *        <--
 *            配置监控中心 第二种方式
 *            7070是dubbo.properties配置文件里的dubbo.protocol.port=7070内容，
 *            Monitor提供的远程服务监听端口，服务提供者和消费者会调用这个端口提供服务，
 *            发送统计信息到Monitor
 *        -->
 *        <dubbo:monitor address="127.0.0.1:7070"></dubbo:monitor>
 * （4）运行生产者和消费者的主程序
 * （5）双击
 *     D:\入门微服务\Dubbo\自己做的笔记\dubbo监控中心\
 *     incubator-dubbo-ops-master\dubbo-monitor-simple\target\
 *     dubbo-monitor-simple-2.0.0\assembly.bin 下的start.bat
 *  (6)输入localhost:8100访问监控中心的主监控界面
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
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
        addressList.forEach(userAddress -> System.out.println(userAddress.getUserAddress()));
        return addressList;
    }
}
