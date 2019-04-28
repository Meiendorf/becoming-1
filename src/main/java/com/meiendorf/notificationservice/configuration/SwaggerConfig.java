package com.meiendorf.notificationservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/email/*"))
                .build()
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Notification service API",
                "Rest api for notification-service app",
                "0.0.3",
                "Terms of serivce",
                new Contact("Melnic Roman", "https://github.com/Meiendorf", "meiendorfu@gmail.com"),
                "MIT license",
                "https://opensource.org/licenses/MIT",
                new ArrayList<>()
        );
        return apiInfo;
    }
}