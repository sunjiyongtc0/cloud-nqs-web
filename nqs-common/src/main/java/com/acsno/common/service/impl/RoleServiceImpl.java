
package com.acsno.common.service.impl;


import com.acsno.common.dao.RoleDao;
import com.acsno.common.entity.RoleEntity;
import com.acsno.common.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 角色
 *
 */
@Service("RoleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService {


	@Transactional(rollbackFor = Exception.class)
	public boolean saveRole(RoleEntity role) {
		role.setCreateTime(new Date().getTime());
		role.setUpdateTime(new Date().getTime());
		role.setDeleteFlag(0);
		return  this.save(role);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<String> queryAllPerms(long  roleId){
		return baseMapper.queryAllPerms(roleId);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<String> AllResPerms(long  roleId){
		List<String>  l=baseMapper.AllResPerms(roleId);
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
