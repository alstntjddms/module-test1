package com.api.config;

import com.common.url.URL;
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
                        .uri(URL.KAKAO_SERVER))

                .route("login_route", p -> p.path("/api/login/**")
                        .uri(URL.LOGIN_SERVER))
                .build();
    }

}