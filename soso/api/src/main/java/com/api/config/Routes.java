package com.api.config;

import com.common.url.URL;
import com.api.config.CustomAuthFilter;
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
                .route("kakao_route", p -> p.path("/api/kakao/**")
                        .filters(f -> f.filter(customAuthFilter.apply(new CustomAuthFilter.Config())))
                        .uri(URL.KAKAO_SERVER))
                .route("login_route", p -> p.path("/api/login/**")
                        .filters(f -> f.filter(customAuthFilter.apply(new CustomAuthFilter.Config())))
                        .uri(URL.AUTH_SERVER))
                .route("log_route", p -> p.path("/api/log/**")
//                        .filters(f -> f.filter(customAuthFilter.apply(new CustomAuthFilter.Config())))
                        .uri(URL.LOG_SERVER))
                .build();
    }

}