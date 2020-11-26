
package com.acsno.common.service.impl;


import com.acsno.common.dao.LogDao;
import com.acsno.common.entity.LogEntity;
import com.acsno.common.service.LogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 日志
 */
@Service("LogService")
public class LogServiceImpl extends ServiceImpl<LogDao, LogEntity> implements LogService {



    public IPage<LogEntity> findByPageService(Page<LogEntity> page, QueryWrapper<LogEntity> wrapper){
       return  baseMapper.findPage(page,wrapper);
    }
}
