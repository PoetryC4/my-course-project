package com.companypowernode.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liyue
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


        @Bean
        public Docket UserApiConfig(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .groupName("UserApi") // 分组
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.companypowernode.controller"))
                    .build();
        }



    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
                .title("上市公司财务分析系统API")
                //创建人
                .contact(new Contact("李越","",""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }



}
