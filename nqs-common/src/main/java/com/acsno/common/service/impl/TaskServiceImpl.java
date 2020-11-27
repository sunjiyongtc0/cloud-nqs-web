
package com.acsno.common.service.impl;



import com.acsno.common.dao.TaskDao;
import com.acsno.common.entity.TaskEntity;
import com.acsno.common.service.TaskService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * 任务
 */
@Service("TaskService")
public class TaskServiceImpl extends ServiceImpl<TaskDao, TaskEntity> implements TaskService {

    public IPage<TaskEntity> findByPageService(Page<TaskEntity> page, QueryWrapper<TaskEntity> wrapper){
        return  baseMapper.findPage(page,wrapper);
    }



}