package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/18 15:04
 * @Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {



    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .enable(true)
                .pathMapping("/")
                .apiInfo(productApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo")) // 拦截的包 路径
                .build();
    }

    private ApiInfo productApiInfo() {

        return new ApiInfoBuilder()
                .title("接口文档")
                .description("")
                .version("1.0.0")
                .build();
    }

}
