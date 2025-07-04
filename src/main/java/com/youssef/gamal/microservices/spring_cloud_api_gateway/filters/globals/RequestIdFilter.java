package com.youssef.gamal.microservices.spring_cloud_api_gateway.filters.globals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.micrometer.tracing.Tracer;
import reactor.core.publisher.Mono;


@Component
public class RequestIdFilter implements GlobalFilter, Ordered {

    public static final String REQUEST_ID_HEADER = "X-Request-Id";

    private final Tracer tracer;

    public RequestIdFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // Get trace and span IDs from headers
        // String traceId = exchange.getRequest().getHeaders().getFirst("X-B3-TraceId");
        // String spanId = exchange.getRequest().getHeaders().getFirst("X-B3-SpanId");

        // System.out.println("Trace ID: " + traceId);
        // System.out.println("Span ID: " + spanId);

        // exchange.getAttributes().forEach((k, v) -> System.out.println("KeyValuePair=" + k + ": " + v));


        // System.out.println("GATEWAY_REACTOR_CONTEXT_ATTR="+ exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REACTOR_CONTEXT_ATTR));
                
        // Generate a unique request ID using the tracer
        // String requestId = tracer.currentSpan().context().traceId();

        // Add the request ID to the response headers
        // exchange.getResponse().getHeaders().add(REQUEST_ID_HEADER, requestId);


        String traceId = null;
        String spanId = null;
        if (tracer.currentSpan() != null) {
            traceId = tracer.currentSpan().context().traceId();
            spanId = tracer.currentSpan().context().spanId();
        } else {
            // Fallback: Try to extract from gatewayReactorContext attribute
            Object ctx = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REACTOR_CONTEXT_ATTR);
            if (ctx != null) {
                Pattern pattern = Pattern.compile("TracingContext\\{span=([a-f0-9]+)/([a-f0-9]+)\\}");
                Matcher matcher = pattern.matcher(ctx.toString());
                if (matcher.find()) {
                    traceId = matcher.group(1);
                    spanId = matcher.group(2);
                }
            }
        }

        System.out.println("Trace ID: " + traceId);
        System.out.println("Span ID: " + spanId);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // Set the order of this filter to be executed after the default filters
        return Ordered.LOWEST_PRECEDENCE;
    }
}