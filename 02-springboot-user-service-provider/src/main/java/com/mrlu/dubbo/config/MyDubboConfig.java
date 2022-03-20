package com.mrlu.dubbo.config;

import com.mrlu.dubbo.service.UserService;
import org.apache.dubbo.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 简单de快乐
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-04-09 23:56
 *
 * 配置类里的内容相当于以下配置
 *
 * #1、指定当前服务/应用的名字（同样的服务名字相同），不要和别的服务同名.一般写模块名称
 * dubbo.application.name=02-springboot-user-service-provider
 *
 * #2、指定注册中心的位置
 * dubbo.registry.address=127.0.0.1:2181
 * dubbo.registry.protocol=zookeeper
 *
 * #3、指定通信规则(通信协议和端口号) 即服务器提供者和服务消费者之间的通信
 * dubbo.protocol.name=dubbo
 * dubbo.protocol.port=20881
 *
 * #4、在要保留的服务上使用@DubboService注解
 * #或者配置扫描该注解所在的@org.apache.dubbo.config.annotation.Service的包
 * # Base packages to scan Dubbo Component: @org.apache.dubbo.config.annotation.Service
 * #dubbo.scan.base-packages=com.mrlu.dubbo.service.impl
 *
 * #5、配置监控中心
 * dubbo.monitor.protocol=registry
 *
 * #设置服务提供的超时时间1s
 * dubbo.provider.timeout=1000
 */
//@Configuration
public class MyDubboConfig {

    /**
     * 相当于dubbo.application.name=02-springboot-user-service-provider
     */
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("02-springboot-user-service-provider");
        return applicationConfig;
    }

    /**
     *  相当于
     * dubbo.registry.address=127.0.0.1:2181
     *  dubbo.registry.protocol=zookeeper
     * @return
     */
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    /**
     * 相当于
     * dubbo.protocol.name=dubbo
     * dubbo.protocol.port=20881
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 相当于@DubboService注解
     * @param userService
     * @return
     */
    @Bean
    public ServiceConfig<UserService> serviceServiceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        //配置每一个方法的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(5000);

        //将method的设置保存到service配置中。
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);
        return serviceConfig;
    }

}
