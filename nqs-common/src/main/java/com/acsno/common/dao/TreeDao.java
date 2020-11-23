package com.acsno.common.dao;


import com.acsno.common.entity.TreeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface TreeDao extends BaseMapper<TreeEntity> {


    List<TreeEntity> getInfoByTreeType(String treeType);
}
