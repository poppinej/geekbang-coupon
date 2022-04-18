package com.geekbang.coupon.calculation.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.geekbang"})
@EnableDiscoveryClient
public class CalculationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculationApplication.class,args);
    }
}
