package com.thallesdaniel.paymentsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket retornaSwagger() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.thallesdaniel.paymentsystem.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(informacoesApi());
    }

    private ApiInfo informacoesApi() {
        return new ApiInfo("Api Payment-system - CriptoPay",
                "Disponibilizando docuemntação para melhor entendimento do projeto. (versão resuzida)",
                "V1", "Api - Livre",
                new Contact("Thalles Daniel", "https://thallesdaniel.com", "contato@thallesdaniel.com"),
                "Termos", "https://github.com/ThallesDaniel/payment-system?tab=License-1-ov-file", Collections.emptyList());
    }
}