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


//�õ��û���ӵ�еĽ�ɫ
@Component//���������spring����
public class LhUserDetailsService implements UserDetailsService {

	// ����username�õ�userDetails����
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		return UserInfoService(username);
	}

	// ȡ���û���Ϣ
	@SuppressWarnings( { "unused", "unchecked" })
	private UserDetails UserInfoService(String username) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		authSet.add(new GrantedAuthorityImpl("����Ա"));
		
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
		// ���������û������Ľ�ɫ�������ݿ���ͨ���û����˺�����ȡ
		for (int i = 0; i < roles.size(); i++) {
			String tempRoleNameString = String.valueOf(roles.get(i));
			authSet.add(new GrantedAuthorityImpl(tempRoleNameString));
		}
		// ��spring security��userdetail��ֵ
		 * 
		 */
		userdetail = new UserInfoSS(username, tempUserInfo.getPassword(),
				tempUserInfo.getEnabled() == 0 ? true : false, true ,
						true,
						true, authSet);
		userdetail.setId(tempUserInfo.getId());
		userdetail.setUserName(tempUserInfo.getUserName());
		userdetail.setRealName(tempUserInfo.getRealName());
		
		try {// У���û��Ƿ�Ϊ��������Ա
			
		} catch (Exception e) {
			userdetail.setIsSuperRole(1);
		}
		
		try {// У���û��Ƿ�Ϊϵͳ����Ա
			
		} catch (Exception e) {
			userdetail.setIsManager(1);
		}
		
		return userdetail;
	}
}
