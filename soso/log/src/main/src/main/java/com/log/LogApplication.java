package com.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(value={"com.common", "com.log"})
public class LogApplication {
	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class, args);
	}
	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer {
		@Override
		public void configurePathMatch(PathMatchConfigurer configurer) {
			configurer.addPathPrefix("/api/log", HandlerTypePredicate.forAnnotation(RestController.class));
		}
	}
}
