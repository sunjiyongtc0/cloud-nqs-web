package com.acsno.webapi.service;

import com.acsno.ext.kit.Ret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value="service-probe")
public interface ProbeFeignService {

    @GetMapping("/probeInfo/getlist")
    Ret getList();

    @GetMapping("/probeInfo/getProbePage")
    Ret getProbePage(@RequestParam("currentPage") long currentPage , @RequestParam("pageSize") long pageSize );


    @GetMapping("/packageInfo/getPackagePage")
    Ret getPackagePage(@RequestParam("currentPage") long currentPage , @RequestParam("pageSize") long pageSize );


    @PostMapping("/packageInfo/savePackagePage")
    Ret savePackagePage(@RequestParam("data") String data );
}
