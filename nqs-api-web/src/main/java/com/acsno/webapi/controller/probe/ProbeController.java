package com.acsno.webapi.controller.probe;


import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.ProbeFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ProbeFeignService probeFeignService;


    @RequestMapping("/index")
    public String index(){
        return "modular/probe/probeList";
    }

    @GetMapping("/list")
    @ResponseBody
    public Ret getList(){
        return probeFeignService.getList();
    }

}
