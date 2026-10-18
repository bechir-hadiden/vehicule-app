package com.example.projetSI.projetSI.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI autoLocOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AutoLoc API - Documentation Swagger UI")
                        .description("Documentation interactive des Web Services REST pour l'application de location de véhicules AutoLoc (ESPRIT - UP ASI)")
                        .version("1.0.0")
                        .contact(new Contact().name("Equipe AutoLoc")));
    }
}
