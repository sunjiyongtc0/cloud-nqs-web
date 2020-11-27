package com.acsno.webapi.controller.report;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/report")
public class ReportController {




    @RequestMapping("/index")
    public String index(){
        return "modular/report/reportList";
    }


}
