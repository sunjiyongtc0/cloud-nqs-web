package com.acsno.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class SnowflakeConfig {
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long workerId = 0;//为终端ID
    private long datacenterId = 1;//数据中心ID
    private Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);
    @PostConstruct
    public void init(){
        workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        log.info("当前机器的workId:{}",workerId);
    }
    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }
    public synchronized long snowflakeId(long workerId,long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}
