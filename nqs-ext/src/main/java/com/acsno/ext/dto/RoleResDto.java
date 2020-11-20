package com.acsno.ext.dto;

import java.io.Serializable;

//用户信息DTO
public class RoleResDto implements Serializable {

    /**
     * 资源ID
     */
    private Long id;



    /**
     * res_id
     */
    private String resId;


    /**
     * 资源父Id
     */
    private String resPid;
    /**
     * 资源名
     * */
    private String  resName;

    /**
     *res_url
     */
    private String  resUrl;

    /**
     * auth_signs
     */
    private String  authSigns;



    /**
     *res_order
     */
    private int  resOrder;

    /**
     * 角色资源表id
     * */
    private String rrId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getResPid() {
        return resPid;
    }

    public void setResPid(String resPid) {
        this.resPid = resPid;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public String getAuthSigns() {
        return authSigns;
    }

    public void setAuthSigns(String authSigns) {
        this.authSigns = authSigns;
    }

    public String getRrId() {
        return rrId;
    }

    public void setRrId(String rrId) {
        this.rrId = rrId;
    }

    public int getResOrder() {
        return resOrder;
    }

    public void setResOrder(int resOrder) {
        this.resOrder = resOrder;
    }

    @Override
    public String toString() {
        return "RoleResDto{" +
                "id=" + id +
                ", resId='" + resId + '\'' +
                ", resPid='" + resPid + '\'' +
                ", resName='" + resName + '\'' +
                ", resUrl='" + resUrl + '\'' +
                ", authSigns='" + authSigns + '\'' +
                ", rrId=" + rrId +
                '}';
    }


}
