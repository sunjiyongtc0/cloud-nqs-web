package com.acsno.pdc.controller;

import com.acsno.common.entity.ResourceEntity;
import com.acsno.common.service.ResourceService;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/resourceInfo")
@Slf4j
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    /**
     * 获取角色的资源
     * */
    @GetMapping("/queryRootByRole/{id}")
    public Ret queryAllByRole(@PathVariable("id") long id){
        List<ResourceEntity > ls = resourceService.queryRootByRole(id);
        JSONArray ja= JSONArray.parseArray(JSON.toJSONString(ls));
        return Ret.ok("res",ja);
    }

    /**
     * 获取角色资源树
     * */
    @GetMapping("/queryTreeByRole")
    public Ret queryTree(long roleId, String resId){
        List<ResourceEntity > ls = resourceService.queryTreeByRole(roleId,resId);
        return Ret.ok("res",getTree(ls,roleId));
    }


    public JSONArray getTree( List<ResourceEntity > ls ,long roleId){
        JSONArray ja= new JSONArray();
        if(ls.size()>0) {
            for (ResourceEntity r : ls) {
                JSONObject j = (JSONObject) JSON.toJSON(r);
                j.put("authSigns",j.getString("authSigns").split(","));
                List<ResourceEntity > ls0 = resourceService.queryTreeByRole(roleId,r.getResId());
                j.put("children", getTree(ls0,roleId));
                ja.add(j);
            }
        }
        return ja ;
    }


}
