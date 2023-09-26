package com.naisilva.oticanordestina.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Ótica Nordestina API",
                version = "1.0.0",
                description = "API implementada Com spring boot utilizando tecnicas de arquitetura limpa"
        )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("com.naisilva.oticanordestina.infrastructure")
                .pathsToMatch("/v1/**")
                .build();
    }
}
