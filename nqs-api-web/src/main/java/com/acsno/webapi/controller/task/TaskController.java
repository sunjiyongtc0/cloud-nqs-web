package com.acsno.webapi.controller.task;


import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.TaskFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskFeignService taskFeignService;


    @RequestMapping("/index")
    public String index(){
        return "modular/task/taskList";
    }


    @GetMapping("/list")
    @ResponseBody
    public Ret getList(){
        return taskFeignService.getList();
    }

}
