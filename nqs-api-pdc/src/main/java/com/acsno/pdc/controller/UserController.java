package com.acsno.pdc.controller;

import com.acsno.common.entity.UserEntity;
import com.acsno.common.service.UserService;
import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/userInfo")
@Slf4j
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * */
    @GetMapping("/getlist")
    public Ret getList(){
       List<UserEntity> lu= userService.list();
        JSONArray ja= JSONArray.parseArray(JSON.toJSONString(lu));
        return Ret.ok("infos",ja).set("serverPort",serverPort);
    }

    /**
     * 根据用户Id获取用户信息
     * */
    @GetMapping("/infoById/{id}")
    public  Ret getInfoById(@PathVariable("id") long id){
        UserDto u= userService.getInfoById(id);
        return Ret.ok("info",u).set("serverPort",serverPort);
    }

    /**
     * 根据用户名称获取用户信息
     * */
    @GetMapping("/getInfoByUserName/{userName}")
    public UserDto  getInfoByUserName(@PathVariable("userName") String userName){
        UserDto u= userService.getInfoByUserName(userName);
        return u;
    }



}
