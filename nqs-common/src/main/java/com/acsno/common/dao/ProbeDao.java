package com.acsno.common.dao;


import com.acsno.common.entity.ProbeEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProbeDao extends BaseMapper<ProbeEntity> {

    IPage<ProbeEntity> findPage(Page<ProbeEntity> page, QueryWrapper<ProbeEntity> wrapper);

}
