package com.acsno.webapi.controller.probe;


import com.acsno.ext.kit.Ret;
import com.acsno.webapi.service.ProbeFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ProbeFeignService probeFeignService;

    @GetMapping("/list")
    public Ret getList(){
        return probeFeignService.getList();
    }

}
