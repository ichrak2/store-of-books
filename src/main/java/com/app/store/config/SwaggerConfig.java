package com.app.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * class for configure Swagger2. Swagger is a test tool for rest APIs.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Docket class which manages all the configurations initializing a Docket object by specifying
     * that we want to use swagger 2 select: allows to initialize a class of the name of
     * ApiSelectorBuilder which gives access to the customization methods apis: is the first important
     * method. It allows you to filter the documentation to be exposed according to the controllers.
     * RequestHandlerSelectors: is a predicate (introduced since java 8) which allows to return TRUE
     * or FALSE depending on the conditions used. paths: this method gives access to another way of
     * filtering: according to the URI of requests
     *
     * @return the docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
