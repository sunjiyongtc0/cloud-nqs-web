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
@RequestMapping("/res")
public class ResourceController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PdcFeignService resFeignService;

    @RequiresPermissions("res:look")
    @RequestMapping("/index")
    public String index(){
            return "modular/pdc/resource";
    }


    @RequiresPermissions("res:operation")
    @ResponseBody
    @PostMapping("/saveResNode")
    @OperLog(logModul ="res/saveResTree",logType = "operation",logDesc = "保存资源树配置")
    public Ret saveResTree(String data){
        resFeignService.saveResNode(data);
        return Ret.ok();
    }

    @GetMapping("/allResList")
    @ResponseBody
    public Ret ResAllResList(){
       return resFeignService.ResAllResList();
    }

}
