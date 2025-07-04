package com.youssef.gamal.microservices.spring_cloud_api_gateway.configs;


import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class RateLimitingConfigs {

    @Bean
    KeyResolver ipKeyResolver() {
    return exchange -> {
        String ip = exchange.getRequest()
                .getRemoteAddress()
                .getAddress()
                .getHostAddress();
        return Mono.just(ip);
    };
}

}
