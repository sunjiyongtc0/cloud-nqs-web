package com.acsno.pdc.controller;

import cn.hutool.core.util.StrUtil;
import com.acsno.common.entity.TreeEntity;
import com.acsno.common.service.TreeService;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/treeInfo")
@Slf4j
public class TreeController {



    @Autowired
    private TreeService treeService;


    @PostMapping("/saveTreeNode")
    public Ret saveTreeNode(@RequestParam("Type") String Type , @RequestParam("data")  String data){
        JSONObject j=JSON.parseObject(data);
        System.out.println(j);
        TreeEntity te=new TreeEntity();
        te.setTreeName(j.getString("treeName")); te.setTreeDesc(j.getString("treeDesc"));
        te.setTreePid(j.getLong("treePid")); te.setTreeOrder(j.getIntValue("treeOrder"));
        te.setTreeType(Type);
        System.out.println(StrUtil.isNotBlank(j.getString("id"))&& j.getInteger("id")>1);
        if( StrUtil.isNotBlank(j.getString("id"))&& j.getInteger("id")>1){
            te.setId(j.getLong("id"));
            treeService.updateById(te);
        }else{
            treeService.save(te);
        }
        return Ret.ok();
    }





    /**
     * 获取树列表
     * */
    @GetMapping("/getTree")
    public Ret getList(String Type){
       List<TreeEntity> lt= treeService.getInfoByTreeType(Type);
        JSONArray ja= new JSONArray();
        for (int  i=0;i<lt.size();i++) {
            TreeEntity t =lt.get(i);
            if(t.getTreePid()==0l){
                JSONObject j = (JSONObject) JSON.toJSON(t);
                j.put("children", getTree(lt,t));
                ja.add(j);
            }
        }
        return Ret.ok("res",ja);
    }

    public JSONArray getTree(List<TreeEntity> lt , TreeEntity t){
        JSONArray ja= new JSONArray();
        for (int  i=0;i<lt.size();i++) {
            TreeEntity te =lt.get(i);
            if(t.getId()==te.getTreePid()){
                JSONObject jo = (JSONObject) JSON.toJSON(te);
                jo.put("children", getTree(lt,te));
                ja.add(jo);
            }
        }
        return ja;
    }

}
