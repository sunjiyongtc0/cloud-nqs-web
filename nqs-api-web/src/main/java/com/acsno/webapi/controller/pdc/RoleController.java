package com.acsno.webapi.controller.pdc;


import com.acsno.ext.kit.Ret;
import com.acsno.webapi.annotation.OperLog;
import com.acsno.webapi.service.PdcFeignService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    @RequiresPermissions("role:look")
    @RequestMapping("/index")
    public String index(){
        return "modular/pdc/role";
    }


    @ResponseBody
    @GetMapping("/list")
    public Ret getList(){
        return roleFeignService.getRoleList();
    }


    @RequiresPermissions("role:update")
    @ResponseBody
    @PostMapping("/add")
    @OperLog(logModul ="role/add",logType = "update",logDesc = "添加角色信息")
    public Ret add(long id,String  roleName,String roleDesc,int status){
        return roleFeignService.addRole(id,roleName,roleDesc,status);
    }

    /**
     * 跳转到角色权限页面
     * */
    @RequiresPermissions("role:operation")
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
        return roleFeignService.getResTreeList(roleId,"0");
    }



    @RequiresPermissions("role:operation")
    @ResponseBody
    @PostMapping("/saveResTree")
    @OperLog(logModul ="role/saveResTree",logType = "operation",logDesc = "保存角色资源树配置")
    public Ret saveResTree(long roleId, String data){
        roleFeignService.saveResArray(roleId, data);
        return Ret.ok();
    }


}
