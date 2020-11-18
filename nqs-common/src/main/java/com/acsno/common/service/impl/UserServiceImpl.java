
package com.acsno.common.service.impl;


import com.acsno.common.dao.UserDao;
import com.acsno.common.entity.UserEntity;
import com.acsno.common.service.UserService;
import com.acsno.common.util.SnowflakeConfig;
import com.acsno.ext.dto.UserDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;



/**
 * 系统用户
 *
 */
@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Autowired
    SnowflakeConfig snowflakeConfig;

	@Transactional(rollbackFor = Exception.class)
	public boolean saveUser(UserEntity user) {
		user.setCreateTime(new Date().getTime());
        user.setId(snowflakeConfig.snowflakeId());
//		//sha256加密
//		String salt = RandomStringUtils.randomAlphanumeric(20);
//		user.setUserSalt(salt);
//		user.setUserPass(ShiroUtils.sha256(user.getUserPass(), user.getUserSalt()));
		return  this.save(user);
	}

	@Transactional(rollbackFor = Exception.class)
	public UserDto getInfoById(long id){
		return baseMapper.getInfoById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public UserDto getInfoByUserName(String userName){
		return baseMapper.getInfoByUserName(userName);
	}


}
