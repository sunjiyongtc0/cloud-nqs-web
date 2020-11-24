package com.acsno.pdc.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.acsno.common.entity.ResourceEntity;
import com.acsno.common.service.ResourceService;
import com.acsno.ext.dto.RoleResDto;
import com.acsno.ext.kit.Ret;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/resourceInfo")
@Slf4j
public class ResourceController {

    @Autowired
    private ResourceService resourceService;


    /**
     * 获取去超管角色权限
     */
    @PostMapping("/AdminResPerms")
    public List<String > AdminResPerms(){
        return resourceService.AdminResPerms();
    }



    /**
     * 角色页面元素资源
     * */
    @GetMapping("/queryRootByRole/{id}")
    public Ret queryAllByRole(@PathVariable("id") long id){
        List<RoleResDto > ls = resourceService.queryRootByRole(id);
        JSONArray ja= new JSONArray();
        for (int  i=0;i<ls.size();i++) {
            RoleResDto r =ls.get(i);
            if("0".equals(r.getResPid())){
                JSONObject j = (JSONObject) JSON.toJSON(r);
                j.put("children", getTree(ls,r));
                ja.add(j);
            }
        }
        return Ret.ok("res",ja);
    }

    /**
     * 新建或者修改资源
     * */
    @PostMapping("/saveRes")
    public Ret saveRes(String  data){
        ResourceEntity resourceEntity=new ResourceEntity();
        JSONObject j=JSON.parseObject(data);
        resourceEntity.setResName(j.getString("resName"));
        resourceEntity.setResUrl(j.getString("resUrl"));
        resourceEntity.setResPid(j.getString("resPid"));
        resourceEntity.setResOrder(j.getInteger("resOrder"));
        resourceEntity.setMenuRemark(j.getString("menuRemark"));
        if( StrUtil.isNotBlank(j.getString("id"))&& j.getInteger("id")>=1){
            resourceEntity.setId(j.getLong("id"));
            resourceEntity.setResId(j.getString("resId"));
            resourceService.updateById(resourceEntity);
        }else{
            resourceEntity.setResId(RandomUtil.randomString(8));
            resourceService.save(resourceEntity);
        }
        System.out.println(resourceEntity.toString());
       return  Ret.ok();
    }

    /**
     * 获取角色资源树
     * */
    @GetMapping("/queryTreeByRole")
    public Ret queryTree(long roleId, String resId){
        List<RoleResDto> ls = resourceService.queryTreeByRole(roleId,resId);
        JSONArray ja= new JSONArray();
        for (int  i=0;i<ls.size();i++) {
            RoleResDto r =ls.get(i);
            if("0".equals(r.getResPid())){
                JSONObject j = (JSONObject) JSON.toJSON(r);
                j.put("authSigns", StrUtil.isNotBlank(j.getString("authSigns"))?j.getString("authSigns").split(","):new JSONArray());
                j.put("children", getTree(ls,r));
                ja.add(j);
            }
        }
        return Ret.ok("res",ja);
    }

    //----------工具类，树型获取
    public JSONArray getTree(List<RoleResDto > ls ,RoleResDto r){
        JSONArray ja= new JSONArray();
        for (int  i=0;i<ls.size();i++) {
            RoleResDto re =ls.get(i);
            if(r.getResId().equals(re.getResPid())){
                JSONObject jo = (JSONObject) JSON.toJSON(re);
                jo.put("authSigns", StrUtil.isNotBlank(jo.getString("authSigns"))?jo.getString("authSigns").split(","):new JSONArray());
                jo.put("children", getTree(ls,re));
                ja.add(jo);
            }
        }
        return ja;
    }

}
