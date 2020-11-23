package com.acsno.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("t_pdc_tree")
public class TreeEntity implements Serializable {

    /**
     *  树ID
     */
    @TableId
    private Long id;

    /**
     * 树名
     */
    private String treeName;

    /**
     * 树描述
     * */
    private String  treeDesc;

    /**
     * 树父Id
     */
    private Long  treePid;

    /**
     * 树地址
     */
    private String  treePath;

    /**
     * 树排序
     */
    private int treeOrder;

    /**
     * 树类型
     */
    private String treeType;

    /**
     * 创建时间
     * */
    private long createTime;

}
