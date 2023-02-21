package com.petvax.petvaxServices;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIDocumentationConfig {
    @Value("petvax@ucmo.edu")
    private String contactEmail;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("petvax-services REST Services")
                        .contact(new Contact()
                                .name("IT")
                                .email(contactEmail))
                );
    }
}
