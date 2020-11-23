package com.acsno.pdc.controller;

import com.acsno.common.entity.UserEntity;
import com.acsno.common.service.UserService;
import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
     * 根据用户组获取用户列表
     * */
    @GetMapping("/getlistByGroup")
    public Ret getListByGroup(long  userGroupId){
        if(userGroupId==0){
            List<UserEntity> lu= userService.list();
            JSONArray ja= JSONArray.parseArray(JSON.toJSONString(lu));
            return Ret.ok("infos",ja).set("serverPort",serverPort);
        }else{
            List<UserEntity> lu= userService.getListByGroup(userGroupId);
            JSONArray ja= JSONArray.parseArray(JSON.toJSONString(lu));
            return Ret.ok("infos",ja).set("serverPort",serverPort);
        }

    }

    @PostMapping("/saveUser")
    public Ret saveUser(String data){
        UserEntity u= JSON.parseObject(data,UserEntity.class);
        if(u.getId()==0){
            userService.save(u);
        }else{
            userService.updateById(u);
        }
        return Ret.ok();
    }

    @DeleteMapping("/deleteUser")
    public Ret deleteUser(@RequestParam("id") long id){
        if(userService.removeById(id)){
            return Ret.ok();
        }else{
            return Ret.fail();
        }

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
