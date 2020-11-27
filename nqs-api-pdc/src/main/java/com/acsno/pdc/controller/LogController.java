package com.acsno.pdc.controller;

import com.acsno.common.entity.LogEntity;
import com.acsno.common.service.LogService;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logInfo")
@Slf4j
public class LogController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private LogService logService;

    @PostMapping("/saveLog")
    public void saveLogOper(@RequestParam("data")  String data){
        LogEntity log=JSON.parseObject(data,LogEntity.class);
        logService.save(log);
    }

    @GetMapping("/getLogList")
    public Ret getList(){
        return Ret.ok("infos",logService.list());
    }

    @GetMapping("/getLogListCount")
    public Ret getLogListCount(){
        return Ret.ok("size",logService.list().size());
    }

    @GetMapping("/getLogPage")
    public Ret getLogPage(@RequestParam("currentPage") long currentPage ,@RequestParam("pageSize") long pageSize ){
        Page<LogEntity> page = new Page<>(currentPage, pageSize);//当前页数：显示第一页数据//每页显示多少：每页显示2条数据
        QueryWrapper<LogEntity> wrapper=new QueryWrapper<>();
        wrapper.setEntity(new LogEntity());
        return Ret.ok("infos",logService.findByPageService(page,wrapper));
    }


}
