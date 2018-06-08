package com.venu.swagger.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {

    return new ApiInfoBuilder()
        .title("Sample Spring Boot Swagger")
        .description("This is a smaple swagger generation for spring boot 2 using spring fox")
        .version("1.0.0")
        .contact(new Contact("Venu", "", "venu@xyz.com"))
        .build();
  }

  /*This is for Spring Boot 2- Use the below lines only if you are using spring boot 2 and if you want Swagger UI, Othersise you don't need to extend WebMvcConfigurationSupport*/
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
