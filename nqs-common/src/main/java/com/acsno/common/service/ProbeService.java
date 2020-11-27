package com.acsno.common.service;

import com.acsno.common.entity.ProbeEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProbeService extends IService<ProbeEntity> {


        IPage<ProbeEntity> findByPageService(Page<ProbeEntity> page, QueryWrapper<ProbeEntity> wrapper);
        }
