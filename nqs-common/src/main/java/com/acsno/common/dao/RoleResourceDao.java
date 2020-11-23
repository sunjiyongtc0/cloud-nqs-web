package com.acsno.common.dao;


import com.acsno.common.entity.RoleResourceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleResourceDao extends BaseMapper<RoleResourceEntity> {

    void RomeByIdNotIn(@Param("roleId") long roleId, @Param("Ids") String Ids);
}
