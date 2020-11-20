package com.acsno.webapi.controller.pdc;


import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.PdcFeignService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PdcFeignService roleFeignService;

    @RequestMapping("/index")
    public String index(){
        return "modular/pdc/role";
    }


    @ResponseBody
    @GetMapping("/list")
    public Ret getList(){
        return roleFeignService.getRoleList();
    }


    /**
     * 添加角色
     * */
    @ResponseBody
    @PostMapping("/add")
    public Ret add(long id,String  roleName,String roleDesc,int status){
        return roleFeignService.addRole(id,roleName,roleDesc,status);
    }

    /**
     * 跳转到角色权限页面
     * */
    @RequestMapping(value = {"/", "roleRes.html/{roleId}"})
    public String roleRes(@PathVariable("roleId") long roleId){
        request.setAttribute("roleId",roleId);
        return "modular/pdc/roleRes";
    }

    /**
     * 获取并配置角色资源树
     * */
    @ResponseBody
    @PostMapping("/getResTree")
    public Ret getResTree(long roleId){
        System.out.println(roleId);
        return roleFeignService.getResTreeList(1,"0");
    }
}
