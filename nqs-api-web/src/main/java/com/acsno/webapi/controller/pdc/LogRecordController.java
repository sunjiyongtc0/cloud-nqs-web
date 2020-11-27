package com.acsno.webapi.controller.pdc;

import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.PdcFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
@RequestMapping("/log")
public class LogRecordController {

    @Resource
    private PdcFeignService logFeignService;

    @RequestMapping("/index")
    public String index(){
        return "modular/pdc/log";
    }



    @GetMapping("/list")
    @ResponseBody
    public Ret getList(){
       return logFeignService.getLogList();
    }
    @GetMapping("/getLogPage")
    @ResponseBody
    public Ret getLogPage(@RequestParam("currentPage") long currentPage , @RequestParam("pageSize") long pageSize ){
        return logFeignService.getLogPage(currentPage,pageSize);
    }
}
