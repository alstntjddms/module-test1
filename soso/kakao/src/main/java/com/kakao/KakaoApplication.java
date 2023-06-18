package com.kakao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(value={"com.common", "com.kakao"})
public class KakaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(KakaoApplication.class, args);
	}
	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer {
		@Override
		public void configurePathMatch(PathMatchConfigurer configurer) {
			configurer.addPathPrefix("/api", HandlerTypePredicate.forAnnotation(RestController.class));
		}
	}
}
