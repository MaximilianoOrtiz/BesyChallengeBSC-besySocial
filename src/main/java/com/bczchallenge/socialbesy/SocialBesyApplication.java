package com.bczchallenge.socialbesy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
//@EnableJpaRepositories(basePackages = "com.bczchallenge.socialbesy.repository")
public class SocialBesyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SocialBesyApplication.class, args);
	}

}
