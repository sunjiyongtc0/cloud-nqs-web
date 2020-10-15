
package com.acsno.webapi.shiro;


//import com.acsno.common.dao.UserDao;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authc.credential.CredentialsMatcher;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
import cn.hutool.core.util.StrUtil;
import com.acsno.ext.dto.UserDto;
import com.acsno.webapi.service.PdcFeignService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 认证
 *
 */
@Component
public class UserRealm extends AuthorizingRealm {
	@Resource
	private PdcFeignService userFeignService;

//    @Autowired
//    private UserDao UserDao;
//    @Autowired
//    private SysMenuDao sysMenuDao;
    
	/**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserDto user = (UserDto)principals.getPrimaryPrincipal();
		Long roleId = user.getRoleId();
		List<String> permsList;
//		//系统管理员，拥有最高权限
////		if(userId == Constant.SUPER_ADMIN){
////			List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
////			permsList = new ArrayList<>(menuList.size());
////			for(SysMenuEntity menu : menuList){
////				permsList.add(menu.getPerms());
////			}
////		}else{
			permsList = userFeignService.queryAllPerms(roleId);
////		}
		//用户权限列表
		Set<String> permsSet = new HashSet<>();
		for(String perms : permsList){
			if(StrUtil.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		//查询用户信息
		UserDto user = userFeignService.getInfoByUserName(token.getUsername());
		//账号不存在
		if(user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		//账号锁定
		if(user.getStatus() == 20){
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPass(), ByteSource.Util.bytes(user.getUserSalt()), getName());
		return info;
	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
