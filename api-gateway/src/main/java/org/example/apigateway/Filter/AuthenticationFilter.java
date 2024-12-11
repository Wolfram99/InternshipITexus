//package org.example.apigateway.Filter;
//
//
//import org.example.apigateway.service.JWtUtils;
//import org.example.apigateway.service.RouterValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@RefreshScope
//@Component
//public class AuthenticationFilter implements GatewayFilter {
//
//
//    private final RouterValidator validator;
//    private final JWtUtils jWtUtils;
//
//    @Autowired
//    public AuthenticationFilter(RouterValidator validator, JWtUtils jWtUtils) {
//        this.validator = validator;
//        this.jWtUtils = jWtUtils;
//    }
//
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
//        ServerHttpRequest request = exchange.getRequest();
//
//
//
//
//
//
//        if(validator.isSecured.test(request)){
//            if(isMissing(request)){
//                return onError(exchange, HttpStatus.UNAUTHORIZED);
//            }
//        }
//        final String token = request.getHeaders().getOrEmpty("Authorization").get(0);
//
//
//        System.out.println(jWtUtils.validateJwtToken(token));
//
//
//        if(!jWtUtils.validateJwtToken(token)){
//            return onError(exchange, HttpStatus.UNAUTHORIZED);
//        }
//
//        System.out.println(chain.filter(exchange));
//        return chain.filter(exchange);
//
//
//    }
//
//    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus status){
//        ServerHttpResponse response = exchange.getResponse();
//        response.setStatusCode(status);
//        return response.setComplete();
//    }
//
//    private boolean isMissing(ServerHttpRequest request){
//        return !request.getHeaders().containsKey("Authorization");
//    }
//
//}
