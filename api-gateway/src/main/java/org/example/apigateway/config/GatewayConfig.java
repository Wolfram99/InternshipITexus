package org.example.apigateway.config;

//import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
//import org.springframework.context.annotation.Bean;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.Customizer;
import java.time.Duration;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.servlet.function.RequestPredicates;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.ServerResponse;
//
//import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
//import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;

@Configuration
public class GatewayConfig {

//    @Bean
//    public RouterFunction<ServerResponse> booksServiceRoute() {
//        return GatewayRouterFunctions.route("books-app")
//                .route(RequestPredicates.path("/api/v0.1/**"), HandlerFunctions.http("http://localhost:8080"))
////                .filter(CircuitBreakerFilterFunctions.circuitBreaker("booksServiceRouteCircuitBreaker"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> workingFilesServiceRoute() {
//        return GatewayRouterFunctions.route("working-files")
//                .route(RequestPredicates.path("api/v0.1/**"), HandlerFunctions.http("http://localhost:8282"))
////                .filter(CircuitBreakerFilterFunctions.circuitBreaker("workingFilesServiceRouteCircuitBreaker"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> authenticationServiceRoute() {
//        return GatewayRouterFunctions.route("authentication-users")
//                .route(RequestPredicates.path("api/v0.1/**"), HandlerFunctions.http("http://localhost:8383"))
////                .filter(CircuitBreakerFilterFunctions.circuitBreaker("authenticationServiceRouteCircuitBreaker"))
//                .build();
//    }

//    @Bean
//    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(200)).build())
//                .build());
//    }

}
//    private final AuthenticationFilter filter;
//
//    @Autowired
//    public GatewayConfig(AuthenticationFilter filter) {
//        this.filter = filter;
//    }
//
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder){
//
//        return builder.routes()
//                .route("authentication-users", r -> r.path("/auth/**")
//                .filters(f -> f.filter(filter))
//                .uri("lb://authentication-users"))
//
//                .route("books-app", r -> r.path("/api/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://books-app"))
//                .route("working-file", r -> r.path("/api/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://working-file"))
//
//
//
//                .build();
//
//
//    }
