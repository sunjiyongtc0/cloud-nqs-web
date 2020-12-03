package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_p_probe_upgrade_package")
public class ProbeUpgradePackageEntity implements Serializable {


    @TableId
    private long id;
    private String name;
    private String  url;
    private long  fileSize;
    private String  fileMd5;
    private String  fileName;
    private String  filePath;
    private String host;
    private String port;
    private String protocol;
    private String createUser;
    private long createTime;
}
