package com.acsno.common.dao;


import com.acsno.common.entity.TaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDao extends BaseMapper<TaskEntity> {

}
