package com.security;



import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


//判断用户是否具有所请求资源所需要的角色权限
public class LhAccessDecisionManager implements AccessDecisionManager {

	private boolean isThrough = true;//当用户不具有访问请求资源的权限时是允许通过还是禁止通过
	private SecurityDAO securityDAO = new SecurityDAO();
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;//如果角色列表为空则放行，相当于系统不对请求资源设置安全屏障
		}
		/*此处放开平台管理员，使其可以观看所有内容*/
		Collection<GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : grantedAuthorities) {
			if (grantedAuthority.getAuthority().equals("平台管理员")) {
				return;
			}
		}
		/*end 放开管理员*/

		// 对应请求资源的系统所有角色权限
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();//configAttributes由LhSecurityMetadataSource得到
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			// 访问所请求资源所需要的角色权限
			String needPermission = configAttribute.getAttribute();
			//System.out.println("访问所请求资源所需要的权限needPermission is " + needPermission);

			// 用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {//authentication由LhUserDetailsService得到
				//System.out.println("用户所拥有的权限ga.getAuthority():" + ga.getAuthority());
				if (needPermission.equalsIgnoreCase(ga.getAuthority())) {// 不区分大小写，但security的xml文件里角色依然区分大小写
					String url = String.valueOf(object);
					String[] link = url.split(":");
					
					try {
						String[] resLink = link[2].trim().toString().split("\\?");
						securityDAO.updateResourse(resLink[0].substring(1));
					} catch (Exception e) {
						securityDAO.updateResourse(link[2].trim());
					}
					
					return;
				}
			}
		}
		if (isThrough) {//相当于没有安全控制
			return;
		}else {//没有角色权限禁止访问
			// 没有权限抛出异常,禁止访问
			throw new AccessDeniedException(" 没有权限访问！");
		}	

	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
