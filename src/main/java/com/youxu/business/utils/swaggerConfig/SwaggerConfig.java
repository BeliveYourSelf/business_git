package com.youxu.business.utils.swaggerConfig;


import org.springframework.beans.factory.annotation.Value;
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
public class SwaggerConfig {
    private String version;
//        @Value("${sop.swagger.host}")
    @Value("localhost:8081")
    private String host;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).host(host)
                .apiInfo(apiInfo())
                .select()
                //扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.youxu.business.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("有需业务小程序")
                //描述
                .description("接口文档")
                //创建人
                //.contact(new Contact("LinXiuNan", "", ""))
                //版本号
                .version("1.0")
                .build();
    }
}
