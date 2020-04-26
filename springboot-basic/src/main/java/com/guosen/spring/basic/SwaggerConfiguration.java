package com.guosen.spring.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()              
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller 中的所有接口              
                .apis(RequestHandlerSelectors.basePackage("com.guosen.spring"))
                .paths(PathSelectors.any()).build();
    }

    /**
     *     * 构建api文档的详细信息     * @return    
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("title-Spring Boot集成Swagger2接口总览")
                // 设置接口描述
                .description("跟哥一起学Spring Boot第06课")
                // 设置联系方式
                .contact("CSDN：http://")
                // 设置版本
                .version("1.1").build();
    }
}
