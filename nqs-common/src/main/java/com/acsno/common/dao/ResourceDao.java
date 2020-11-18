package com.acsno.common.dao;


import com.acsno.common.entity.ResourceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResourceDao extends BaseMapper<ResourceEntity> {

    List<ResourceEntity> queryRootByRole(long roleId);

    List<ResourceEntity>  queryTreeByRole(@Param("roleId") long roleId, @Param("resId") String resId);
}
