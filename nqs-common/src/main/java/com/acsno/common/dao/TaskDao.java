package com.acsno.common.dao;


import com.acsno.common.entity.TaskEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDao extends BaseMapper<TaskEntity> {


    IPage<TaskEntity> findPage(Page<TaskEntity> page, QueryWrapper<TaskEntity> wrapper);
}
