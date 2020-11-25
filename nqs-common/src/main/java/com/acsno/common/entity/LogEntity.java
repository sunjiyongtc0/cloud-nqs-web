package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@TableName("t_pdc_log")
public class LogEntity implements Serializable {

    /**
     * 用户ID
     */
    @TableId
    private Long id;

    private String logDesc;


    private String  logModul;

    private String  ips;

    private String  createUser;
    /**
     * 角色ID
     * */
    private long roleId;
    /**
     * 创建时间
     * */
    private long createTime;
    private int  status;


    private String logType;


    private String methodName;


}
