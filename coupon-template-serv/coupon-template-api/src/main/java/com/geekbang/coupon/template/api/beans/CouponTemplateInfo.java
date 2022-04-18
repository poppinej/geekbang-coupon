package com.geekbang.coupon.template.api.beans;

import com.geekbang.coupon.template.api.beans.rules.TemplateRule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponTemplateInfo {


    private Long id;

    private String name;

    /**
     *订单最低多少钱才能用优惠券，单位为分
     */
    private String desc;
    /**
     *优惠券类型(引用CouponType里的code)
     */
    @NotNull
    private String type;

    /**
     *优惠券适用门店 - 若无则为全店通用券
     */
    private Long shopId;

    /**
     *优惠券使用规则
     */
    @NotNull
    private TemplateRule rule;

    /**
     *当前模板是否为可用状态
     */
    private Boolean available;

}
