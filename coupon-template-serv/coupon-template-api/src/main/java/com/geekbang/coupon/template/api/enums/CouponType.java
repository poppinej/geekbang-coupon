package com.geekbang.coupon.template.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum CouponType {

    /**
     * 未知
     */
    UNKNOWN("unknown", "0"),
    /**
     *满减券
     */
    MONEY_OFF("满减券", "1"),
    /**
     *打折
     */
    DISCOUNT("打折", "2"),
    /**
     *随机减
     */
    RANDOM_DISCOUNT("随机减", "3"),
    /**
     *晚间双倍优惠券
     */
    LONELY_NIGHT_MONEY_OFF("晚间双倍优惠券", "4"),

    ANTI_PUA("对抗PUA优惠券","5");


    private String description;

    private String code;

    public static CouponType convert(String code){

        return Stream.of(values())
                .filter(bean-> bean.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }






}
