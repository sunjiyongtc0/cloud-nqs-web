package com.acsno.webapi.controller.pdc;

import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.PdcFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
@RequestMapping("/log")
public class LogRecordController {

    @Resource
    private PdcFeignService userFeignService;

    @RequestMapping("/index")
    public String index(){
        return "modular/pdc/log";
    }


//    /**
//     * 获取用户列表
//     * */
//    @GetMapping("/list")
//    @ResponseBody
//    public Ret getList(){
//        //获取当前登录用户信息
//        UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
//       return userFeignService.getUserList().set("Shiro" ,userDto);
//    }
//
//    /**
//     * 根据用户id后去用户DTO信息
//     * */
//    @ResponseBody
//    @GetMapping("/Info/{id}")
//    public Ret getUserInfo(@PathVariable("id") long id){
//        return userFeignService.getUserInfoById(id);
//    }
}
