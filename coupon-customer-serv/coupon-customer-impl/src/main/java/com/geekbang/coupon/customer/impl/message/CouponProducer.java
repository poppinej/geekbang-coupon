package com.geekbang.coupon.customer.impl.message;

import com.geekbang.coupon.customer.api.beans.RequestCoupon;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.EventConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Service
@Slf4j
public class CouponProducer {


    @Autowired
    private StreamBridge streamBridge;

    public void sendCoupon(RequestCoupon coupon){

        log.info("sent:{}",coupon);
        streamBridge.send(EventConstant.ADD_COUPON_EVENT,coupon);
    }


    public void deleteCoupon(Long userId,Long couponId){

        streamBridge.send(EventConstant.DELETE_COUPON_EVENT,userId+","+couponId);
    }
}
