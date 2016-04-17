package com.security;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.management.relation.RoleInfo;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;


//加载资源与权限的对应关系，并判断系统资源是否包含请求资源
@SuppressWarnings("unchecked")
public class LhSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private boolean isThrough = true;// 当系统资源不包含请求资源时是允许通过还是禁止通过,true:只判断系统配置的资源，false：系统未配置的资源一概交由后面的过滤器来判断
	private SecurityDAO securityDAO = new SecurityDAO();

	// 初始化系统资源
	public LhSecurityMetadataSource() {
		// 这里程序加载了系统中的资源
		this.loadResourceDefine();
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	// 加载所有资源与角色权限的对应关系
	private void loadResourceDefine() {
		try {
			System.out.println("0000");
			if (resourceMap == null) {
				resourceMap = new HashMap<String, Collection<ConfigAttribute>>();// 资源和角色的对应关系
				System.out.println("-------------加载系统权限-------------");
				
				//List<Resources> resList = (List<Resources>) securityDAO.findAllResourse();
				//for (Resources res : resList ) {// 按资源寻找有权限的角色
					Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();// 角色列表
					List<RoleInfo> roles = securityDAO.findRolesById(1);
					for (RoleInfo role : roles) {// 拥有特定资源的所有角色
						ConfigAttribute configAttribute = new SecurityConfig(
								role.getName());
						configAttributes.add(configAttribute);
					}
					resourceMap.put("" + "*", configAttributes);// 将资源和角色存为一对多的map结构
					// configAttributes.removeAll(configAttributes);
				//}

			}
			
		} catch (Exception e) {
			System.err.println("出现异常！！！");
		}
	}

	// 返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		String requestUrl = ((FilterInvocation) object).getRequestUrl();// 请求的资源
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = "/" + ite.next();// 系统资源
			boolean isInclude = urlMatcher.pathMatchesUrl(resURL, requestUrl);// 判断系统资源是否包含请求的资源
			if (isInclude) {
				return resourceMap.get(resURL.substring(1));// 返回请求资源所对应的角色权限
			}
		}
		if (isThrough) {// 放行
			return null;
		} else {
			if (resourceMap == null) {
				//loadResourceDefine();
			}
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();// 角色列表
			if (resourceMap.get(requestUrl) == null) {// 请求的资源系统中没有对应项，则构造一个虚拟角色，然后由LhAccessDecisionManager进行拦截
				ConfigAttribute configAttribute = new SecurityConfig(
						"NONE_ROLE");// 意味着角色命名不要为 NONE_ROLE
				configAttributes.add(configAttribute);
			}
			return configAttributes;
		}
	}

	public void reLoadResourceMap() {

		try {
			/**song
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();// 资源和角色的对应关系
			List<Resources> resList = (List<Resources>) securityDAO
					.findAllResourse();
			for (Resources res : resList) {// 按资源寻找有权限的角色
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();// 角色列表
				List<String> roles = securityDAO.findRolesByResourse(res
						.getId());
				for (String role : roles) {// 拥有特定资源的所有角色
					ConfigAttribute configAttribute = new SecurityConfig(role);
					configAttributes.add(configAttribute);
				}
				resourceMap.put(res.getResLink() + "*", configAttributes);// 将资源和角色存为一对多的map结构
			}
			*/
		} catch (Exception e) {
			System.err.println("出现异常！！！");
		}
	}

	public static Map<String, Collection<ConfigAttribute>> getResourceMap() {
		return resourceMap;
	}

	public static void setResourceMap(
			Map<String, Collection<ConfigAttribute>> resourceMap) {
		LhSecurityMetadataSource.resourceMap = resourceMap;
	}
}