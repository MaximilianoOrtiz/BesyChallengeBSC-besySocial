package com.bczchallenge.socialbesy.config;

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
@EnableSwagger2
public class SpringFoxSwagger {

    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com/bczchallenge/socialbesy/controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "SocialBesy API",
                "API para el manejo de interaccion entre usuarios de un sistema de compra/venta",
                "V2",
                "Terminos del servicio",
                new Contact("Maximiliano Ortiz", "www.gogle.com", "maxiortiz_22@hotmail.com"),
                "Licencia de API", "API licencia url", Collections.emptyList()
        );
    }

}
