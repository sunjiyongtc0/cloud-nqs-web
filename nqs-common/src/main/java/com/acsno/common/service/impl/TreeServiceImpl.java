
package com.acsno.common.service.impl;


import com.acsno.common.dao.TreeDao;
import com.acsno.common.entity.TreeEntity;
import com.acsno.common.service.TreeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * 树
 */
@Service("TreeService")
public class TreeServiceImpl extends ServiceImpl<TreeDao, TreeEntity> implements TreeService {



	@Transactional(rollbackFor = Exception.class)
	public List<TreeEntity> getInfoByTreeType(String treeType){
		return baseMapper.getInfoByTreeType(treeType);
	}



}
