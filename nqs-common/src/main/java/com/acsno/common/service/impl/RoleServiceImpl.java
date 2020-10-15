
package com.acsno.common.service.impl;


import com.acsno.common.dao.RoleDao;
import com.acsno.common.entity.RoleEntity;
import com.acsno.common.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return  this.save(role);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<String> queryAllPerms(long  roleId){
		return baseMapper.queryAllPerms(roleId);
	}

}
