package com.geekbang.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class TemplateRule {


    /**
     * 可以享受的折扣
     */
    private Discount discount;

    /**
     * 每个人最多可以领的数量
     */
    private Integer limitation;
    /**
     * 过期时间
     */
    private Long deadLine;
}
