package com.geekbang.coupon.calculation.impl.template;

import com.geekbang.coupon.calculation.api.beans.ShoppingCart;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
public interface RuleTemplate {

    // 计算优惠券
    ShoppingCart calculate(ShoppingCart settlement);

}
