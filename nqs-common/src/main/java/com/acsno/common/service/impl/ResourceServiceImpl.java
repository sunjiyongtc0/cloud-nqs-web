
package com.acsno.common.service.impl;


import com.acsno.common.dao.ResourceDao;
import com.acsno.common.entity.ResourceEntity;
import com.acsno.common.service.ResourceService;
import com.acsno.ext.dto.RoleResDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 资源
 *
 */
@Service("ResourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, ResourceEntity> implements ResourceService {




	@Transactional(rollbackFor = Exception.class)
	public List<RoleResDto> queryRootByRole(long  roleId){
		return baseMapper.queryRootByRole(roleId);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<RoleResDto> queryTreeByRole(long roleId, String resId){
//		Map<String ,Object> m=new HashMap<String,Object>();
//		m.put("roleId",roleId);m.put("resId",resId);
		return baseMapper.queryTreeByRole(roleId,resId);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<String> AdminResPerms(){
		List<String>  l=baseMapper.AdminResPerms();
		List<String>  lnew=new ArrayList<String>();
		for(String s:l){
			String key=s.split("-")[0];
			String value=s.split("-")[1];
			for(String v:value.split(",")){
				lnew.add(key+":"+v);
			}
		}
		return lnew;
	}
}
