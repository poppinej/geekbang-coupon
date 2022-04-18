package com.learn.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

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
public class GatewayService {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void updateRoutes(List<RouteDefinition> routes){

        if(CollectionUtils.isEmpty(routes)){

            log.info("No route find!");
            return;
        }

        routes.forEach(r->{
            try{
                routeDefinitionWriter.save(Mono.just(r)).subscribe();
                applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
            }catch (Exception e){
                log.error("cant update route, id ={}",r.getId());
            }
        });

    }
}
