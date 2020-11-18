
package com.acsno.common.service.impl;


import com.acsno.common.dao.ResourceDao;
import com.acsno.common.entity.ResourceEntity;
import com.acsno.common.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 资源
 *
 */
@Service("ResourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourceEntity> implements ResourceService {




	@Transactional(rollbackFor = Exception.class)
	public List<ResourceEntity> queryRootByRole(long  roleId){
		return baseMapper.queryRootByRole(roleId);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<ResourceEntity> queryTreeByRole( long roleId, String resId){
//		Map<String ,Object> m=new HashMap<String,Object>();
//		m.put("roleId",roleId);m.put("resId",resId);
		return baseMapper.queryTreeByRole(roleId,resId);
	}
}
