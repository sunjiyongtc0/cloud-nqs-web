package com.acsno.common.service;

import com.acsno.common.entity.TaskEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TaskService extends IService<TaskEntity> {


    IPage<TaskEntity> findByPageService(Page<TaskEntity> page, QueryWrapper<TaskEntity> wrapper);
}
