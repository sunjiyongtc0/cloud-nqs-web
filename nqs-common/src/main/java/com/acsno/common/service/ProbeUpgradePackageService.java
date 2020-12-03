package com.acsno.common.service;

import com.acsno.common.entity.ProbeUpgradePackageEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProbeUpgradePackageService extends IService<ProbeUpgradePackageEntity> {


        IPage<ProbeUpgradePackageEntity> findByPageService(Page<ProbeUpgradePackageEntity> page, QueryWrapper<ProbeUpgradePackageEntity> wrapper);
        }
