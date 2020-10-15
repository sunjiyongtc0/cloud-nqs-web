package com.acsno.common.service;

import com.acsno.common.entity.RoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RoleService extends IService<RoleEntity> {
    /**
     * 保存角色
     */
    boolean saveRole(RoleEntity role);


    /**
     * 获取角色的权限内容
     * */
    List<String> queryAllPerms(long  roleId);
}
