package com.acsno.webapi.controller.pdc;

import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.PdcFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HttpServletRequest request;
    @Resource
    private PdcFeignService resFeignService;

    @RequestMapping("/index")
    public  String index(){
        //获取当前登录用户信息
        UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("username", userDto.getRealName());
        return "index";
    }

    @RequestMapping(value = {"/", "home.html"})
    public String home(){
        return "home";
    }

    @ResponseBody
    @GetMapping("/findRoot")
    public  Ret findRoot(){
        UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
        return resFeignService.getResList(userDto.getRoleId());
    }

    @ResponseBody
    @GetMapping("/findTree")
    public  Ret findTree(String resId){
        UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
        return resFeignService.getResTreeList(userDto.getRoleId(),resId);
    }
}
