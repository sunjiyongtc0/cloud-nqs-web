package com.acsno.pdc.controller;

import com.acsno.common.entity.LogEntity;
import com.acsno.common.entity.UserEntity;
import com.acsno.common.service.LogService;
import com.acsno.common.service.UserService;
import com.acsno.ext.dto.UserDto;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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





}
