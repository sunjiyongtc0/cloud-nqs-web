package com.acsno.webapi.controller.pdc;

import com.acsno.ext.kit.Ret;
import com.acsno.webapi.annotation.OperLog;
import com.acsno.webapi.service.PdcFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/tree")
public class TreeController {

    @Resource
    private PdcFeignService treeFeignService;

    /**
     *  获取用户列表树
     * */
    @GetMapping("/usertree")
    public Ret getUserList(){
       return treeFeignService.getTreeListByType("user");
    }


    @RequiresPermissions("tree:operation")
    @PostMapping("/saveUserNode")
    @OperLog(logModul ="tree/saveUserNode",logType = "operation",logDesc = "保存或修改用户树")
    public Ret saveUserNode(String data){
        return treeFeignService.saveTreeNode("user",data);
    }

}
