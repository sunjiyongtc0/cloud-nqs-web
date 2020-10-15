package com.acsno.webapi.controller.pdc;

import com.acsno.ext.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HttpServletRequest request;


    @RequestMapping("/index")
    public  String index(){
        //获取当前登录用户信息
        UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
        System.out.println(userDto.toString());
        request.setAttribute("username", userDto.getRealName());
        return "index";
    }

    @RequestMapping(value = {"/", "home.html"})
    public String home(){
        return "home";
    }

}
