package com.acsno.common.service;

import com.acsno.common.entity.ResourceEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface ResourceService extends IService<ResourceEntity> {



    /**
     * 根据角色获取根资源信息
     * */
    List<ResourceEntity> queryRootByRole(long roleId);

    /**
     * 根据角色获取二三级资源信息
     * */
    List<ResourceEntity> queryTreeByRole(long roleId,String resId);
}