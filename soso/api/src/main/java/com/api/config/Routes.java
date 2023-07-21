package com.api.config;

import com.common.url.URL;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder, CustomAuthFilter customAuthFilter) {

        return builder
                .routes()
                // 카카오 서버 라우팅
                .route("kakao_route", p -> p.path("/api/kakao/**")
                        .filters(f -> f.filter(customAuthFilter.apply(new CustomAuthFilter.Config())))
                        .uri(URL.KAKAO_SERVER))

                // 로그인 서버 라우팅
                .route("login_route", p -> p.path("/api/login/**")
                        .filters(f -> f.filter(customAuthFilter.apply(new CustomAuthFilter.Config())))
                        .uri(URL.AUTH_SERVER))

                // 로그 서버 라우팅
                .route("log_route", p -> p.path("/api/log/**")
//                        .filters(f -> f.filter(customAuthFilter.apply(new CustomAuthFilter.Config())))
                        .uri(URL.LOG_SERVER))
                .build();
    }

}