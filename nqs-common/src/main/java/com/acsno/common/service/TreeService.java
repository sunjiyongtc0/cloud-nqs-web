package com.acsno.common.service;

import com.acsno.common.entity.TreeEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


public interface TreeService extends IService<TreeEntity> {


    List<TreeEntity> getInfoByTreeType(String treeType);



}
