package com.acsno.common.dao;


import com.acsno.common.entity.LogEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LogDao extends BaseMapper<LogEntity> {

    IPage<LogEntity> findPage(Page<LogEntity> page, QueryWrapper<LogEntity> wrapper);

}
