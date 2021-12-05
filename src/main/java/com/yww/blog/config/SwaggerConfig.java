package com.yww.blog.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * <p>
 *     Swagger的配置类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 15:36
 **/
@Configuration
public class SwaggerConfig {

    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfig(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean
    public Docket docket(){
        //调用apiInfo方法来传入信息
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yww.blog.controller"))
                .build()
                .extensions(openApiExtensionResolver.buildExtensions("yww"));
    }

    /**
     * 自定义信息
     * @return ApiInfo
     */
    private ApiInfo apiInfo(){
        //创建一个contact对象以便输入
        Contact contact = new Contact("yw", "localhost:9090/", "1141950370@qq.com");
        return new ApiInfo(
                "Yw的swagger文档",
                "永远相信美好的事情即将发生",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "https://www.apache.org/licenses/LINCENSE-2.0 ",
                new ArrayList<>()
        );
    }
}
