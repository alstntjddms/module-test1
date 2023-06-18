package com.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LoginApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer {
		@Override
		public void configurePathMatch(PathMatchConfigurer configurer) {
			configurer.addPathPrefix("/api", HandlerTypePredicate.forAnnotation(RestController.class));
		}
	}

}
