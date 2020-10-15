package com.acsno.webapi.service;

import com.acsno.ext.kit.Ret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value="service-task")
public interface TaskFeignService {

    @GetMapping("/task/getlist")
    Ret getList();


}
