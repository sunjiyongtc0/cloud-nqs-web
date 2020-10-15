package com.acsno.probe.controller;

import com.acsno.common.entity.ProbeEntity;
import com.acsno.common.entity.UserEntity;
import com.acsno.common.service.ProbeService;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/probe")
@Slf4j
public class ProbeController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private ProbeService probeService;

    /**
     * 获取探针列表
     * */
    @GetMapping("/getlist")
    public Ret getList(){
       List<ProbeEntity> lp= probeService.list();
        JSONArray ja= JSONArray.parseArray(JSON.toJSONString(lp));
        return Ret.ok("infos",ja).set("serverPort",serverPort);
    }




}
