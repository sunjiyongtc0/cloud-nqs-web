package com.acsno.common.dao;


import com.acsno.common.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao extends BaseMapper<RoleEntity> {

    List<String> queryAllPerms(long  roleId);

}
