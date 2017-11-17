package com.sunny;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Filename:    SwaggerConfig.java  
 * Description: Swagger配置文件  
 * Copyright:   Copyright (c) 2012-2013 All Rights Reserved.
 * Company:     golden-soft.com Inc.
 * @author:     LiShuang
 * @version:    1.0  
 * Create at:   2017年11月17日 下午3:46:22  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2017年11月17日      LiShuang    1.0         1.0 Version
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * 可以定义多个组，比如本类中定义把test和demo区分开了 (访问页面就可以看到效果)
	 */
	@Bean
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())  //配置说明
				.groupName("api") //定义组
				.ignoredParameterTypes(User.class)
				.select()  //选择哪些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.sunny.controller"))  //拦截包路径
				.paths(PathSelectors.any()).build();
	}
	
	@Bean
	public Docket testApi2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())  //配置说明
				.groupName("api2") //定义组
				.ignoredParameterTypes(User.class)
				.select()  //选择哪些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.sunny.controller"))  //拦截包路径
				.paths(PathSelectors.any()).build();
	}

	/**
	 * @Api(value = "UserController", description = "用户相关api")
	 * @ApiOperation(value = "查找用户", notes = "查找用户", httpMethod = "GET", produces =
	 *                     MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * @ApiImplicitParams用在方法上包含一组参数说明 用在
	 * @ApiImplicitParams注解中，指定一个请求参数的各个方面 paramType：参数放在哪个地方
	 *                                     header–>请求参数的获取：@RequestHeader
	 *                                     query–>请求参数的获取：@RequestParam
	 *                                     path（用于restful接口）–>请求参数的获取：@PathVariable
	 *                                     body（不常用） form（不常用） name：参数名
	 *                                     dataType：参数类型 required：参数是否必须传
	 *                                     value：参数的意思 defaultValue：参数的默认值
	 * @ApiResponses用于表示一组响应
	 * @ApiResponse 一般用于表达一个错误的响应信息
	 * @ApiModel描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
	 * @ApiModelProperty(value = "登录用户")
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("api根地址：http://api.xiaomo.info:8080/").termsOfServiceUrl("https://xiaomo.info/")
				.contact("sunny").version("1.0").build();

		/*
		 * ApiInfo apiInfo=new ApiInfo("SpringBoot学习",//大标题
		 * "Spring boot + swagger + mybatis + druid",//小标题 "1.0",//版本
		 * "NO terms of service", "15869426788@163.com",//作者 "Sunny",//链接显示文字
		 * "http://www.sunny.shuang/"//网站链接 ); return apiInfo;
		 */
	};

}
