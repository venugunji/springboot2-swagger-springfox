package com.venu.swagger.swaggerspringfoxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.venu.swagger"})
public class SwaggerSpringfoxDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwaggerSpringfoxDemoApplication.class, args);
  }
}
