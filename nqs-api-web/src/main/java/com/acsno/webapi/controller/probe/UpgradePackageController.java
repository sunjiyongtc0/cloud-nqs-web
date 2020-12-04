package com.acsno.webapi.controller.probe;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.acsno.webapi.annotation.OperLog;
import com.acsno.webapi.service.ProbeFeignService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.util.UuidUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
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
    public Ret uploadPackagePage(@RequestParam("package") String packageInfo ,@RequestPart(value = "file",required = false) MultipartFile file){
        JSONObject info= JSON.parseObject(packageInfo);
        if(info.containsKey("id")&& file==null){
            packageFeignService.savePackagePage(info.toJSONString());
            return Ret.ok("msg","数据修改成功！");
        }else{
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
                info.put("fileSize",dest.length());
                info.put("fileName",OriginalFile);
                info.put("filePath",filePath+fileName);
                info.put("fileMd5", DigestUtils.md5Hex(new FileInputStream(filePath + fileName) ));
                info.put("url",info.getString("protocol")+"://"+info.getString("host")+":"+info.getString("port")+"/file/"+fileName);
                UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
                info.put("createUser",userDto.getUserId());
                info.put("createTime",System.currentTimeMillis()/1000);
                packageFeignService.savePackagePage(info.toJSONString());
                return Ret.ok("msg","文件上传成功！");
            } catch (IOException e) {
                return Ret.fail("msg",e.getMessage());
            }
        }


    }
}
