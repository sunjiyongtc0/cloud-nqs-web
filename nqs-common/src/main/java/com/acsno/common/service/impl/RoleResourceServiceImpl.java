
package com.acsno.common.service.impl;


import com.acsno.common.dao.RoleResourceDao;
import com.acsno.common.entity.RoleResourceEntity;
import com.acsno.common.service.RoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 资源
 *
 */
@Service("RoleResourceService")
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceDao, RoleResourceEntity> implements RoleResourceService {


    @Transactional(rollbackFor = Exception.class)
    public void RomeByIdNotIn(long roleId, String Ids) {
        baseMapper.RomeByIdNotIn(roleId,Ids);
    }
}
