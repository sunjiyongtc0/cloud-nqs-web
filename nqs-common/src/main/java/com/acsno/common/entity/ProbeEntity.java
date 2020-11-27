package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_p_probe")
public class ProbeEntity implements Serializable {


//    @TableId
    private String id;
    private String probeName;
    private String  probeAlias;
    private int  type;
    private String  ip;
    private String  internetIp;
    private int  status;
    private int operator;
    private String softVer;
    private long lastRegistTime;
    private long lastHeartbeatTime;
    private String vendor;
    private String sn;
    private String pc;

}
