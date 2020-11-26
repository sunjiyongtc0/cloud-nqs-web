package com.acsno.common.service;

import com.acsno.common.entity.LogEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface LogService extends IService<LogEntity> {

    IPage<LogEntity> findByPageService(Page<LogEntity> page, QueryWrapper<LogEntity> wrapper);
}
