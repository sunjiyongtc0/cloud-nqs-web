package com.acsno.pdc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
//扫描mybatis数据服务
@MapperScan("com.acsno.common.dao")

@ComponentScan(basePackages={"com.acsno"})
public class PdcApplication {
    public static void main(String[] args) {
        SpringApplication.run(PdcApplication.class, args);
    }
}
