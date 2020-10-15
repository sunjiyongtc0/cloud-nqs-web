package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@TableName("t_pdc_user")
public class UserEntity implements Serializable {

    /**
     * 用户ID
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 真实姓名
     * */
    private String  realName;

    /**
     *用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    private String  userPass;

    /**
     * 盐
     */
    private String  userSalt;

    /**
     * 邮箱
     */
    @NotBlank(message="邮箱不能为空")
//    @Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String userEmail;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 创建时间
     * */
    private long createTime;

}
