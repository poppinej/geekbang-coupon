package com.geekbang.coupon.customer.impl.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Configuration
public class WebConfiguration {


    @Bean
    @LoadBalanced
    public WebClient.Builder register(){
        return WebClient.builder();
    }

    @Bean
    Logger.Level feignLogger(){

        return Logger.Level.FULL;
    }
}
