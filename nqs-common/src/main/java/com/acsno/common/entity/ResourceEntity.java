package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("t_pdc_resource")
public class ResourceEntity implements Serializable {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 资源id
     */
    private String resId;

    /**
     * 资源名称
     * */
    private String  resName;

    /**
     *资源url
     */
    private String  resUrl;
    /**
     * 资源顺序
     */
    private int  resOrder;

    /**
     * 父资源
     */
    private String  resPid;

    /**
     * 权限关键字
     * */
    private String authSigns;

    private String menuRemark;

    @Override
    public String toString() {
        return "ResourceEntity{" +
                "id=" + id +
                ", resId='" + resId + '\'' +
                ", resName='" + resName + '\'' +
                ", resUrl='" + resUrl + '\'' +
                ", resOrder=" + resOrder +
                ", resPid='" + resPid + '\'' +
                ", authSigns='" + authSigns + '\'' +
                '}';
    }
}
