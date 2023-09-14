package com.alticci.labseq.config;

import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Alticci API")
                        .description("2023 Altice Labs Exercise")
                        .version("1.0").contact(
                        new Contact()
                                .name("Cleyton Sousa Santos")
                                .email("cleytonsouza808@gmail.com")));
    }
}