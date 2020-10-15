package com.acsno.webapi.service;

import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value="service-pdc")
public interface PdcFeignService {

    @GetMapping("/userInfo/getlist")
    Ret getUserList();

    @GetMapping("/userInfo/infoById/{id}")
    Ret getUserInfoById(@PathVariable("id") long id);

    @GetMapping("/roleInfo/getlist")
    Ret getRoleList();

    @GetMapping("/roleInfo/queryAllPerms/{id}")
    List<String> queryAllPerms(@PathVariable("id") long id);

    @GetMapping("/userInfo/getInfoByUserName/{userName}")
    UserDto getInfoByUserName(@PathVariable("userName") String userName);
}
