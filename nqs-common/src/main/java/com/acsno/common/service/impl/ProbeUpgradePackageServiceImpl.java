
package com.acsno.common.service.impl;


import com.acsno.common.dao.ProbeUpgradePackageDao;
import com.acsno.common.entity.ProbeUpgradePackageEntity;
import com.acsno.common.service.ProbeUpgradePackageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 探针升级包
 *
 */
@Service("ProbeUpgradePackageService")
public class ProbeUpgradePackageServiceImpl extends ServiceImpl<ProbeUpgradePackageDao, ProbeUpgradePackageEntity> implements ProbeUpgradePackageService {

    public IPage<ProbeUpgradePackageEntity> findByPageService(Page<ProbeUpgradePackageEntity> page, QueryWrapper<ProbeUpgradePackageEntity> wrapper){
        return  baseMapper.findPage(page,wrapper);
    }


}
