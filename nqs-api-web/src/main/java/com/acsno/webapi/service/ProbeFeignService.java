package com.acsno.webapi.service;

import com.acsno.ext.kit.Ret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value="service-probe")
public interface ProbeFeignService {

    @GetMapping("/probeInfo/getlist")
    Ret getList();

    @GetMapping("/probeInfo/getProbePage")
    Ret getProbePage(@RequestParam("currentPage") long currentPage , @RequestParam("pageSize") long pageSize );

}
