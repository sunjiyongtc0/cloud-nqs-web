package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_t_task_param")
public class TaskEntity implements Serializable {

    /**
     * ID
     */
    @TableId
    private String id;

    /**
     * 测试任务名字
     */
    private String taskParamName;

    /**
     * 任务类型名称
     * */
    private String  taskTypeName;

    /**
     *参数类型
     */
    private int  taskParamType;

    /**
     * 测试任务参数配置json
     */
    private String  paramJson;

    /**
     * 任务描述
     */
    private String  memo;

    /**
     * 参数状态
     */
    private int  runStatus;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 创建时间
     * */
    private long createTime;

}
