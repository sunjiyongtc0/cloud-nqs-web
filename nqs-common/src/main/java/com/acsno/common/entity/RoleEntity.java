package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@TableName("t_pdc_role")
public class RoleEntity implements Serializable {

    /**
     * 用户ID
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "角色名不能为空")
    private String roleName;

    /**
     * 角色描述
     * */
    private String  roleDesc;

    /**
     *是否删除
     */
    private int  deleteFlag;

    /**
     * 角色状态
     */
    private int  status;

    /**
     * 邮箱
     */
    @NotBlank(message="邮箱不能为空")
    private Long rolePid;


    /**
     * 创建时间
     * */
    private long createTime;

    /**
     * 修改时间
     * */
    private long updateTime;
}
