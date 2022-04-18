package com.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Configuration
public class RoutesConfiguration {

    @Autowired
    private KeyResolver hostAddrKeyResolver;

    @Autowired
    @Qualifier("customerRateLimiter")
    private RateLimiter customerRateLimiter;

    @Autowired
    @Qualifier("templateRateLimiter")
    private RateLimiter templateRateLimiter;


    @Bean
    public RouteLocator declare(RouteLocatorBuilder builder){
        return builder.routes()
                .route(route -> route
                .path("/gateway/coupon-customer/**")
                .filters(f ->f.stripPrefix(1)
                .requestRateLimiter(limiter ->{
                    limiter.setKeyResolver(hostAddrKeyResolver);
                    limiter.setRateLimiter(customerRateLimiter);
                    limiter.setStatusCode(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
                }))
                .uri("lb://coupon-customer-serv")
                )
                .route(route -> route
                .order(1)
                .path("/gateway/template/**")
                .filters(f->f.stripPrefix(1))
                .uri("lb://coupon-template-serv"))
                .route(route -> route
                        .path("/gateway/calculator/**")
                        .filters(f->f.stripPrefix(1))
                        .uri("lb://coupon-calculator-serv"))
                .build();
    }
}
