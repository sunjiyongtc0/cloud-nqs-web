package com.acsno.task.controller;

import com.acsno.common.entity.ProbeEntity;
import com.acsno.common.entity.TaskEntity;
import com.acsno.common.service.TaskService;
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
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private TaskService taskService;

    /**
     * 获取任务列表
     * */
    @GetMapping("/getlist")
    public Ret getList(){
       List<TaskEntity> lp= taskService.list();
        JSONArray ja= JSONArray.parseArray(JSON.toJSONString(lp));
        return Ret.ok("infos",ja).set("serverPort",serverPort);
    }




}
