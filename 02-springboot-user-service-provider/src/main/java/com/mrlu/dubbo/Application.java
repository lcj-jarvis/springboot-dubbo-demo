package com.mrlu.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @EnableDubbo注解
 *
 * Springboot整合Dubbo的三种方式
 * （1）导入dubbo-starter，在application.properties配置属性，使用@DubboService和@DubboReference属性进行纯配置
 * （2）使用dubbo xml配置文件，将xml配置文件加到类路径下。
 *     然后在springboot的主配置类上使用@ImportResource(locations = "classpath:provider.xml")
 *  (3)使用注解API的方式
 *      将每一个组件手动创建到容器中，让dubbo来扫描其他组件。（即编写一个配置类）
 */
@EnableDubbo
//@ImportResource(locations = "classpath:provider.xml")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
