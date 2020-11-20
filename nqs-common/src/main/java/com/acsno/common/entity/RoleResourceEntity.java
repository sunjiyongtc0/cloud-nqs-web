package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_pdc_role_resource")
public class RoleResourceEntity implements Serializable {

    /**
     * ID
     */
    @TableId
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getAuthSigns() {
        return authSigns;
    }

    public void setAuthSigns(String authSigns) {
        this.authSigns = authSigns;
    }

    private String roleId;
    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 权限关键字
     * */
    private String authSigns;

}
