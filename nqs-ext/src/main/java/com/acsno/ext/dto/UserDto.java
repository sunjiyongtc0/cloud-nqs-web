package com.acsno.ext.dto;

import java.io.Serializable;

//用户信息DTO
public class UserDto implements Serializable {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     * */
    private String  realName;

    /**
     *用户密码
     */
    private String  userPass;

    /**
     * 盐
     */
    private String  userSalt;

    /**
     * 角色id
     * */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;



    /**
     * 用户状态
     * */
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", status=" + status +
                '}';
    }

}
