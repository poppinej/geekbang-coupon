package com.geekbang.coupon.customer.impl.message;

import com.geekbang.coupon.customer.api.beans.RequestCoupon;
import com.geekbang.coupon.customer.impl.service.intf.CouponCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Slf4j
@Service
public class CouponConsumer {

    @Autowired
    private CouponCustomerService couponCustomerService;

    @Bean
    public Consumer<RequestCoupon> addCoupon(){
        return request -> {
            couponCustomerService.requestCoupon(request);
        };
    }


    @Bean
    public Consumer<String> deleteCoupon(){

        return request ->{
            List<Long> params = Arrays.stream(request.split(","))
                    .map(Long::valueOf)
                    .collect(Collectors.toList());
            couponCustomerService.deleteCoupon(params.get(0),params.get(1));
        };
    }

    @ServiceActivator(inputChannel = "request-coupon-topic.add-coupon-group.errors")
    public void requestCouponFallback(ErrorMessage errorMessage){

        log.info("consumer error:{}",errorMessage);

        throw new RuntimeException("打到死信队列");
    }
}
