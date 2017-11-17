package com.sunny;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Filename:    App.java  
 * Description: 主程序  
 * Copyright:   Copyright (c) 2012-2013 All Rights Reserved.
 * Company:     golden-soft.com Inc.
 * @author:     Sunny 
 * @version:    1.0  
 * Create at:   2017年11月9日 下午5:49:44  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2017年11月9日      Sunny       1.0         1.0 Version
 */
@ServletComponentScan  //配置Druid监听
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.sunny")
@MapperScan(basePackages = "com.sunny.dao.mapper")
public class App extends SpringBootServletInitializer{
     
	 /**
	  * 启动主程序，该程序是利用maven插件进行生成mapper接口和entity实体类
	  * 只需要在项目的
	  */
     public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	 }
     /**
      * 设置文件上传大小
      */
     @Bean
     public MultipartConfigElement multipartConfigElement() {
       MultipartConfigFactory factory=new MultipartConfigFactory();  	 
    	 factory.setMaxFileSize("5MB");
    	 factory.setMaxRequestSize("5MB");
    	 return factory.createMultipartConfig();
     }
	
}
