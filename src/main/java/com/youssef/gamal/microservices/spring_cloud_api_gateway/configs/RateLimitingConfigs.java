package com.youssef.gamal.microservices.spring_cloud_api_gateway.configs;


import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import reactor.core.publisher.Mono;

@Configuration
public class RateLimitingConfigs {


    // @Bean
    // KeyResolver ipKeyResolver() {
    //     return exchange -> {
    //         String ip = exchange.getRequest()
    //                 .getRemoteAddress()
    //                 .getAddress()
    //                 .getHostAddress();
    //         return Mono.just(ip);
    //     };
    // }



    @Bean
    // @Primary
    KeyResolver userNameResolver() {
        return exchange -> exchange.getPrincipal()
            .flatMap(principal -> {
                String username = principal.getName();
                if (username == null) {
                    System.out.println("Using userNameResolver for Rate Limiting >>> anonymous (principal name is null)");
                    return Mono.just("anonymous");
                } else {
                    System.out.println("Using userNameResolver for Rate Limiting >>> " + username);
                    return Mono.just(username);
                }
            })
            .switchIfEmpty(Mono.fromRunnable(() ->
                System.out.println("Using userNameResolver for Rate Limiting >>> anonymous (no principal found)")
            ).thenReturn("anonymous"));
    }

}
