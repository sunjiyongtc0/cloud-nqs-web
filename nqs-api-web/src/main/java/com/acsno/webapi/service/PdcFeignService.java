package com.acsno.webapi.service;

import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value="service-pdc")
public interface PdcFeignService {

    @GetMapping("/userInfo/getlist")
    Ret getUserList();

    @GetMapping("/userInfo/infoById/{id}")
    Ret getUserInfoById(@PathVariable("id") long id);

    @PostMapping("/roleInfo/add")
    Ret addRole(@RequestParam("id") long id,@RequestParam("roleName") String  roleName,@RequestParam("roleDesc") String roleDesc, @RequestParam("status") int status);

    @GetMapping("/roleInfo/getlist")
    Ret getRoleList();

    @GetMapping("/roleInfo/queryAllPerms/{id}")
    List<String> queryAllPerms(@PathVariable("id") long id);

    @GetMapping("/userInfo/getInfoByUserName/{userName}")
    UserDto getInfoByUserName(@PathVariable("userName") String userName);

    @GetMapping("/resourceInfo/queryRootByRole/{id}")
    Ret getResList(@PathVariable("id") long id);

    @GetMapping("/resourceInfo/queryTreeByRole")
    Ret getResTreeList(@RequestParam("roleId") long roleId, @RequestParam("resId") String resId);

    @PostMapping("/roleInfo/saveResArray")
    Ret saveResArray(@RequestParam("roleId") long roleId,@RequestParam("data")  String data);

    @PostMapping("/resourceInfo/saveRes")
    Ret saveResNode(@RequestParam("data")  String data);
}
