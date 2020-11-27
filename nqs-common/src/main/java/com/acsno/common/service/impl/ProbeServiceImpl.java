
package com.acsno.common.service.impl;


import com.acsno.common.dao.ProbeDao;
import com.acsno.common.entity.ProbeEntity;
import com.acsno.common.service.ProbeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 探针
 *
 */
@Service("ProbeService")
public class ProbeServiceImpl extends ServiceImpl<ProbeDao, ProbeEntity> implements ProbeService {

    public IPage<ProbeEntity> findByPageService(Page<ProbeEntity> page, QueryWrapper<ProbeEntity> wrapper){
        return  baseMapper.findPage(page,wrapper);
    }


}
