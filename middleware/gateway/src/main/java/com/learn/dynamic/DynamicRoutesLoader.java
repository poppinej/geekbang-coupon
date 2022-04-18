package com.learn.dynamic;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 *
 * @author 吴艺杰
 * @version 1.0
 */
@Configuration
public class DynamicRoutesLoader implements InitializingBean {


    @Autowired
    private NacosConfigManager configService;
    @Autowired
    private NacosConfigProperties configProperties;
    @Autowired
    private DynamicRoutesListener dynamicRoutesListener;

    private static final String ROUTES_CONFIG = "routes-config.json";

    @Override
    public void afterPropertiesSet() throws Exception {

        String routes = configService.getConfigService().getConfig(
                ROUTES_CONFIG,configProperties.getGroup(),10000);

        dynamicRoutesListener.receiveConfigInfo(routes);

        configService.getConfigService().addListener(ROUTES_CONFIG,configProperties.getGroup(),dynamicRoutesListener);

    }
}
