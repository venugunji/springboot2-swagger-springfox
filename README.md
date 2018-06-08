# springboot2-swagger-springfox
This Repo will describe how to generate swagger documentation with springfox for a spring boot2 application

**Key points:**

 1. If you want just swagger.json file
		 a.  add the below dependency in pom.xml

		    <dependency\>
			  <groupId\>io.springfox</groupId\>
			  <artifactId\>springfox-swagger2</artifactId\>
			  <version\>2.9.0</version\>
			</dependency\>
	b. Add SwaggerConfig.java as below. the API info is optional.


		 @Configuration
		 @EnableSwagger2
		 public class SwaggerConfig {
		 @Bean
		 public Docket api() {
		  return new Docket(DocumentationType.SWAGGER_2)
		  .apiInfo(apiInfo())
		  .select()
		  .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
		  .paths(PathSelectors.any()) .build();
		  }
		 private ApiInfo apiInfo() {
			 return new ApiInfoBuilder()
			  .title("Sample Spring Boot Swagger")
			 .description("This is a smaple swagger generation for spring boot 2 using spring fox")
			 .version("1.0.0")
			 .contact(new Contact("Venu", "", ""))
			  .build();
			  }
			  }
2. If you want UI as well,
	a. In addition to the above dependency, add the below one.

	     <dependency\>
	      <groupId\>io.springfox</groupId\>
	      <artifactId\>springfox-swagger-ui</artifactId\>
	      <version\>2.9.0</version\>
	    </dependency\>
	b. SwaggerConfig.java


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
		        .contact(new Contact("Venu", "", ""))
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


## How to access
Once the application is started,

For json file,use the url : http://localhost:8080/v2/api-docs

For UI , use the url: http://localhost:8080/swagger-ui.html#/

![Alt text](jsonscreenshot.png?raw=true "Json")

![Alt text](swaggerUI.png?raw=true "UI")

