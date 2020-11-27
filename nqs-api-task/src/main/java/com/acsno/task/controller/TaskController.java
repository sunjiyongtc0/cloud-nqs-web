package com.acsno.task.controller;

import com.acsno.common.entity.LogEntity;
import com.acsno.common.entity.TaskEntity;
import com.acsno.common.service.TaskService;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/taskInfo")
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

    @GetMapping("/getTaskPage")
    public Ret getTaskPage(@RequestParam("currentPage") long currentPage , @RequestParam("pageSize") long pageSize){
        Page<TaskEntity> page = new Page<>(currentPage, pageSize);//当前页数：显示第一页数据//每页显示多少：每页显示2条数据
        QueryWrapper<TaskEntity> wrapper=new QueryWrapper<>();
        wrapper.setEntity(new TaskEntity());
        return Ret.ok("infos",taskService.findByPageService(page,wrapper));
    }


}
