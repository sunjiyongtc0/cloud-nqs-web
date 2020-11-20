package com.acsno.webapi.controller.pdc;

import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.PdcFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private PdcFeignService userFeignService;

    @RequestMapping("/index")
    public String index(){
        return "modular/pdc/user";
    }


    /**
     * 获取用户列表
     * */
    @GetMapping("/list")
    @ResponseBody
    public Ret getList(){
        //获取当前登录用户信息
        UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
       return userFeignService.getUserList().set("Shiro" ,userDto);
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
