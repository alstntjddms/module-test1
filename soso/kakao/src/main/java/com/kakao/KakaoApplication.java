package com.kakao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(value={"com.common", "com.kakao"})
public class KakaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(KakaoApplication.class, args);
	}

}
