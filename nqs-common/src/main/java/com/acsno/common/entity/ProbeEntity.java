package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("t_p_probe")
public class ProbeEntity implements Serializable {

    /**
     * ID
     */
    @TableId
    private String id;

    /**
     * 探针名称
     */
    private String probeName;

    /**
     * 探针别名
     * */
    private String  probeAlias;

    /**
     *探针类型
     */
    private int  type;

    /**
     * ip
     */
    private String  ip;

    /**
     * 探针状态
     */
    private int  status;

    /**
     * 软件版本（插件）
     */
    private String softVer;

    /**
     * 最后心跳时间（秒）
     * */
    private long lastHeartbeatTime;

}
