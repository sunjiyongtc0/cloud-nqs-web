package com.acsno.webapi.controller.pdc;


import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.PdcFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private PdcFeignService roleFeignService;

    @GetMapping("/list")
    public Ret getList(){
        return roleFeignService.getRoleList();
    }


}
