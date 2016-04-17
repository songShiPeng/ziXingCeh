package com.security;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.model.Userinfo;


//得到用户所拥有的角色
@Component//把这个类让spring管理
public class LhUserDetailsService implements UserDetailsService {

	// 根据username得到userDetails对象
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		return UserInfoService(username);
	}

	// 取得用户信息
	@SuppressWarnings( { "unused", "unchecked" })
	private UserDetails UserInfoService(String username) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		authSet.add(new GrantedAuthorityImpl("管理员"));
		
		SecurityDAO securityDAO = new SecurityDAO();
		//RoleAction roleAction = new RoleAction();
		UserInfoSS userdetail;
		Userinfo tempUserInfo = securityDAO.findUserInfoByUserName(username);
		
		if (tempUserInfo == null) {
			userdetail = new UserInfoSS("", "", false, false, false, false,
					authSet);
			return userdetail;
		}
		if(tempUserInfo.getUserType().equals("1")){
			authSet.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}
		else{
			authSet.add(new GrantedAuthorityImpl("ROLE_USER"));
		}
		/**List<String> roles = (List<String>) securityDAO.findRolesById(tempUserInfo.getId());
		// 这里设置用户所属的角色，从数据库中通过用户的账号来获取
		for (int i = 0; i < roles.size(); i++) {
			String tempRoleNameString = String.valueOf(roles.get(i));
			authSet.add(new GrantedAuthorityImpl(tempRoleNameString));
		}
		// 给spring security的userdetail赋值
		 * 
		 */
		userdetail = new UserInfoSS(username, tempUserInfo.getPassword(),
				tempUserInfo.getEnabled() == 0 ? true : false, true ,
						true,
						true, authSet);
		userdetail.setId(tempUserInfo.getId());
		userdetail.setUserName(tempUserInfo.getUserName());
		userdetail.setRealName(tempUserInfo.getRealName());
		
		try {// 校验用户是否为超级管理员
			
		} catch (Exception e) {
			userdetail.setIsSuperRole(1);
		}
		
		try {// 校验用户是否为系统管理员
			
		} catch (Exception e) {
			userdetail.setIsManager(1);
		}
		
		return userdetail;
	}
}
