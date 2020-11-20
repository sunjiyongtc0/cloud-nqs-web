package com.acsno.pdc.controller;

import com.acsno.common.entity.RoleEntity;
import com.acsno.common.entity.UserEntity;
import com.acsno.common.service.RoleService;
import com.acsno.common.service.UserService;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/roleInfo")
@Slf4j
public class RoleController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RoleService roleService;

    /**
     * 新建修改角色
     * */
    @PostMapping("/add")
    public  Ret addRole(long id,String  roleName,String roleDesc,int status){
        if(id==0){
            RoleEntity roleEntity=new RoleEntity();
            roleEntity.setRoleName(roleName);   roleEntity.setRoleDesc(roleDesc);
            roleEntity.setStatus(status);
            roleService.saveRole(roleEntity);
        }else{
            RoleEntity roleEntity=new RoleEntity();
            roleEntity.setId(id);               roleEntity.setRoleName(roleName);
            roleEntity.setRoleDesc(roleDesc);   roleEntity.setStatus(status);
            roleEntity.setUpdateTime(new Date().getTime());
            roleService.updateById(roleEntity);
        }
        return Ret.ok();
    }


    /**
     * 获取角色列表
     * */
    @GetMapping("/getlist")
    public Ret getList(){
       List<RoleEntity> lu= roleService.list();
        JSONArray ja= JSONArray.parseArray(JSON.toJSONString(lu));
        return Ret.ok("infos",ja).set("serverPort",serverPort);
    }

    /**
     * 根据角色Id获取用户信息
     * */
    @GetMapping("/infoById/{id}")
    public  Ret getInfoById(@PathVariable("id") long id){
        RoleEntity u= roleService.getById(id);
        return Ret.ok("info",u).set("serverPort",serverPort);
    }

    /**
     * 获取角色的权限信息
     * */
    @GetMapping("/queryAllPerms/{id}")
    public List<String > queryAllPerms(@PathVariable("id") long id){
        List<String > ls = roleService.queryAllPerms(id);
        return  ls;
    }

}
