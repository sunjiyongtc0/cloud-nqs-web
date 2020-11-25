
package com.acsno.common.service.impl;


import com.acsno.common.dao.LogDao;
import com.acsno.common.entity.LogEntity;
import com.acsno.common.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * 日志
 */
@Service("LogService")
public class LogServiceImpl extends ServiceImpl<LogDao, LogEntity> implements LogService {

}
