package com.geekbang.coupon.calculation.impl.template.impl;

import com.geekbang.coupon.calculation.impl.template.AbstractRuleTemplate;
import com.geekbang.coupon.calculation.impl.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Slf4j
@Component
public class RandomReductionTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
        // 计算使用优惠券之后的价格
        Long maxBenefit = Math.min(shopAmount, quota);
        int reductionAmount = new Random().nextInt(maxBenefit.intValue());
        Long newCost = totalAmount - reductionAmount;

        log.debug("original price={}, new price={}", totalAmount, newCost);
        return newCost;
    }
}