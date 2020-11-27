package com.acsno.probe.controller;

import com.acsno.common.entity.ProbeEntity;
import com.acsno.common.service.ProbeService;
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
@RequestMapping("/probeInfo")
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
       List<ProbeEntity> lp=probeService.list();
        JSONArray ja= JSONArray.parseArray(JSON.toJSONString(lp));
        return Ret.ok("infos",ja).set("serverPort",serverPort);
    }

    @GetMapping("/getProbePage")
    public Ret getProbePage(@RequestParam("currentPage") long currentPage , @RequestParam("pageSize") long pageSize){
        Page<ProbeEntity> page = new Page<>(currentPage, pageSize);//当前页数：显示第一页数据//每页显示多少：每页显示2条数据
        QueryWrapper<ProbeEntity> wrapper=new QueryWrapper<>();
        wrapper.setEntity(new ProbeEntity());
        return Ret.ok("infos",probeService.findByPageService(page,wrapper));
    }


}
