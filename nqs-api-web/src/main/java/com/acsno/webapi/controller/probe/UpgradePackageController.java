package com.acsno.webapi.controller.probe;


import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.acsno.ext.kit.Ret;
import com.acsno.webapi.annotation.OperLog;
import com.acsno.webapi.service.ProbeFeignService;
import com.alibaba.nacos.common.util.UuidUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/probePackage")
public class UpgradePackageController {

    @Autowired
    private ProbeFeignService packageFeignService;

    @RequestMapping("/index")
    public String index(){
        return "modular/probe/upgradePackage";
    }

    @GetMapping("/getPackagePage")
    @ResponseBody
    public Ret getPackagePage(@RequestParam("currentPage") long currentPage , @RequestParam("pageSize") long pageSize ){
        return packageFeignService.getPackagePage(currentPage,pageSize);
    }
    @PostMapping("/uploadPackagePage")
    @ResponseBody
    @RequiresPermissions("user:update")
    @OperLog(logModul ="probePackage/uploadPackagePage",logType = "update",logDesc = "新建升级包")
    public Ret uploadPackagePage(@RequestParam("package") String packageInfo ,@RequestPart("file") MultipartFile file){
        if (file.isEmpty()) {
            return Ret.fail("msg","上传失败，请选择文件");
        }
        String OriginalFile = file.getOriginalFilename();
        String suffix = org.apache.commons.io.FilenameUtils.getExtension(OriginalFile);
        String fileName = RandomUtil.randomString(8)+"."+suffix;
        String filePath = "D:/Program Files/nginx-1.14.2/html/file/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            //TODO
            return Ret.ok("msg","文件上传成功！");
        } catch (IOException e) {
            return Ret.fail("msg",e.getMessage());
        }

    }
}
