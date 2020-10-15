package com.acsno.pdc.controller;

import com.acsno.common.entity.UserEntity;
import com.acsno.ext.kit.Ret;
import com.acsno.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/doLogin")
    public String  doLogin(String username, String password){
        UserEntity u=new UserEntity();
        u.setUserName("manager");
        u.setUserPass("manager");
        u.setRealName("管理员");
        userService.saveUser(u);
        return Ret.ok().toJson();
    }

}
