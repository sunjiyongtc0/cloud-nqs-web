package com.acsno.webapi.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//该配置为Ribbon配置项 +RestTemplate 起到网管效果
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
