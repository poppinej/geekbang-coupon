package com.geekbang.coupon.customer.impl.feign;

import com.geekbang.coupon.calculation.api.beans.ShoppingCart;
import com.geekbang.coupon.calculation.api.beans.SimulationOrder;
import com.geekbang.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@FeignClient(value = "coupon-calculation-serv",path = "/calculator")
public interface CalculationService {

    @PostMapping("/checkout")
    ShoppingCart checkout(ShoppingCart settlement);



    @PostMapping("/simulate")
    SimulationResponse simulate(SimulationOrder simulator);
}
