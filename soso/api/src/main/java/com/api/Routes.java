package com.api;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("kakao_route", p -> p.path("/api/kakao/**")
                        .uri("http://localhost:8081"))

                .route("login_route", p -> p.path("/api/login/**")
                        .uri("http://localhost:8082"))
                .build();
    }

}