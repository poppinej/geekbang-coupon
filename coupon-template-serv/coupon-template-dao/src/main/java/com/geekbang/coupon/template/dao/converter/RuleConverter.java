package com.geekbang.coupon.template.dao.converter;

import com.alibaba.fastjson.JSON;
import com.geekbang.coupon.template.api.beans.rules.TemplateRule;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Converter
public class RuleConverter implements AttributeConverter<TemplateRule,String> {

    @Override
    public String convertToDatabaseColumn(TemplateRule templateRule) {
        return JSON.toJSONString(templateRule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String s) {
        return JSON.parseObject(s,TemplateRule.class);
    }
}
