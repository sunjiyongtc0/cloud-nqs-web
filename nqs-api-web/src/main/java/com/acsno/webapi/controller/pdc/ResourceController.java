package com.acsno.webapi.controller.pdc;


import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.PdcFeignService;
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

    @RequestMapping("/index")
    public String index(){
            return "modular/pdc/resource";
    }

    /**
     * 保存角色资源树配置
     * */
    @ResponseBody
    @PostMapping("/saveResNode")
    public Ret saveResTree(String data){
        resFeignService.saveResNode(data);
        return Ret.ok();
    }

}
