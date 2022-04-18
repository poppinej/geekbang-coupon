package com.learn.dynamic;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.cms.PasswordRecipientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

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
public class DynamicRoutesListener implements Listener {

    @Autowired
    private GatewayService gatewayService;


    @Override
    public Executor getExecutor() {

        log.info("getExecutor");
        return null;
    }

    @Override
    public void receiveConfigInfo(String s) {

        List<RouteDefinition> definitionList = JSON.parseArray(s,RouteDefinition.class);
        gatewayService.updateRoutes(definitionList);
    }
}
