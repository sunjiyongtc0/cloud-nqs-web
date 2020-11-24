package com.acsno.common.service;

import com.acsno.common.entity.ResourceEntity;
import com.acsno.ext.dto.RoleResDto;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface ResourceService extends IService<ResourceEntity> {



    /**
     * 根据角色获取根资源信息
     * */
    List<RoleResDto> queryRootByRole(long roleId);

    /**
     * 根据角色获取二三级资源信息
     * */
    List<RoleResDto> queryTreeByRole(long roleId, String resId);


    List<String> AdminResPerms();
}
