package com.bobwares.climate.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

public class SwaggerRestConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerRestConfiguration.class);

	@Value("${swagger.api.title:}")
	private String apiTitle;
	@Value("${swagger.api.description:}")
    private String apiDescription;
	@Value("${swagger.api.version:}")
    private String apiVersion;
	@Value("${swagger.api.termsOfService:}")
    private String apiTermsOfService;
	@Value("${swagger.api.contactName:}")
    private String apiContactName;
	@Value("${swagger.api.contactUrl:}")
    private String apiContactUrl;
	@Value("${swagger.api.contactEmail:}")
    private String apiContactEmail;
	@Value("${swagger.api.licence:}")
    private String apiLicence;
	@Value("${swagger.api.licenceUrl:}")
    private String apiLicenceUrl;

    @Value("${server.port}")
    private int serverPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public SwaggerRestConfiguration() {
		LOGGER.info("Starting ... SwaggerRestConfiguration");
			}

	@Bean
	public Docket api() {
        LOGGER.info("Swagger UI URL: http://localhost:" +  serverPort + contextPath + "/swagger-ui.html");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(apiTitle)
				.description(apiDescription)
				.version(apiVersion)
				.termsOfServiceUrl(apiTermsOfService)
				.contact(new Contact(apiContactName, apiContactUrl, apiContactEmail))
				.license(apiLicence)
				.licenseUrl(apiLicenceUrl)
				.build();
	}
}
