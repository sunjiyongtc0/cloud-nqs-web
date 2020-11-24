package com.acsno.webapi.controller.pdc;

import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.acsno.webapi.controller.BaseController;
import com.acsno.webapi.service.PdcFeignService;
import com.acsno.webapi.shiro.ShiroUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private PdcFeignService userFeignService;

    @RequiresPermissions("user:look")
    @RequestMapping("/index")
    public String index(){
        return "modular/pdc/user";
    }


    /**
     * 获取用户列表
     * */

    @GetMapping("/list")
    @ResponseBody
    public Ret getList(long userGroupId){
        if(userGroupId==1){
            userGroupId=0l;
        }
        //获取当前登录用户信息
        UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
       return userFeignService.getlistByGroup( userGroupId ).set("Shiro" ,userDto);
    }
    @RequiresPermissions("user:update")
    @PostMapping("/saveUser")
    public Ret saveUser(@RequestParam("data") String data){
        JSONObject j=JSON.parseObject(data);
        //sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
        j.put("userSalt" ,salt);
        j.put("userPass" ,ShiroUtils.sha256(j.getString("userPass"), j.getString("userSalt" )));
        System.out.println(j);
        return userFeignService.saveUser(j.toJSONString());
    }
    public Ret deleteUser(@RequestParam("id") long id){
        System.out.println("=====>"+id);
        return userFeignService.deleteUser(id);

    }



    /**
     * 根据用户id后去用户DTO信息
     * */
    @ResponseBody
    @GetMapping("/Info/{id}")
    public Ret getUserInfo(@PathVariable("id") long id){
        return userFeignService.getUserInfoById(id);
    }
}
