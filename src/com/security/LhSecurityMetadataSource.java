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


//������Դ��Ȩ�޵Ķ�Ӧ��ϵ�����ж�ϵͳ��Դ�Ƿ����������Դ
@SuppressWarnings("unchecked")
public class LhSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private boolean isThrough = true;// ��ϵͳ��Դ������������Դʱ������ͨ�����ǽ�ֹͨ��,true:ֻ�ж�ϵͳ���õ���Դ��false��ϵͳδ���õ���Դһ�Ž��ɺ���Ĺ��������ж�
	private SecurityDAO securityDAO = new SecurityDAO();

	// ��ʼ��ϵͳ��Դ
	public LhSecurityMetadataSource() {
		// ������������ϵͳ�е���Դ
		this.loadResourceDefine();
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	// ����������Դ���ɫȨ�޵Ķ�Ӧ��ϵ
	private void loadResourceDefine() {
		try {
			System.out.println("0000");
			if (resourceMap == null) {
				resourceMap = new HashMap<String, Collection<ConfigAttribute>>();// ��Դ�ͽ�ɫ�Ķ�Ӧ��ϵ
				System.out.println("-------------����ϵͳȨ��-------------");
				
				//List<Resources> resList = (List<Resources>) securityDAO.findAllResourse();
				//for (Resources res : resList ) {// ����ԴѰ����Ȩ�޵Ľ�ɫ
					Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();// ��ɫ�б�
					List<RoleInfo> roles = securityDAO.findRolesById(1);
					for (RoleInfo role : roles) {// ӵ���ض���Դ�����н�ɫ
						ConfigAttribute configAttribute = new SecurityConfig(
								role.getName());
						configAttributes.add(configAttribute);
					}
					resourceMap.put("" + "*", configAttributes);// ����Դ�ͽ�ɫ��Ϊһ�Զ��map�ṹ
					// configAttributes.removeAll(configAttributes);
				//}

			}
			
		} catch (Exception e) {
			System.err.println("�����쳣������");
		}
	}

	// ������������Դ����Ҫ��Ȩ��
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		String requestUrl = ((FilterInvocation) object).getRequestUrl();// �������Դ
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = "/" + ite.next();// ϵͳ��Դ
			boolean isInclude = urlMatcher.pathMatchesUrl(resURL, requestUrl);// �ж�ϵͳ��Դ�Ƿ�����������Դ
			if (isInclude) {
				return resourceMap.get(resURL.substring(1));// ����������Դ����Ӧ�Ľ�ɫȨ��
			}
		}
		if (isThrough) {// ����
			return null;
		} else {
			if (resourceMap == null) {
				//loadResourceDefine();
			}
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();// ��ɫ�б�
			if (resourceMap.get(requestUrl) == null) {// �������Դϵͳ��û�ж�Ӧ�����һ�������ɫ��Ȼ����LhAccessDecisionManager��������
				ConfigAttribute configAttribute = new SecurityConfig(
						"NONE_ROLE");// ��ζ�Ž�ɫ������ҪΪ NONE_ROLE
				configAttributes.add(configAttribute);
			}
			return configAttributes;
		}
	}

	public void reLoadResourceMap() {

		try {
			/**song
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();// ��Դ�ͽ�ɫ�Ķ�Ӧ��ϵ
			List<Resources> resList = (List<Resources>) securityDAO
					.findAllResourse();
			for (Resources res : resList) {// ����ԴѰ����Ȩ�޵Ľ�ɫ
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();// ��ɫ�б�
				List<String> roles = securityDAO.findRolesByResourse(res
						.getId());
				for (String role : roles) {// ӵ���ض���Դ�����н�ɫ
					ConfigAttribute configAttribute = new SecurityConfig(role);
					configAttributes.add(configAttribute);
				}
				resourceMap.put(res.getResLink() + "*", configAttributes);// ����Դ�ͽ�ɫ��Ϊһ�Զ��map�ṹ
			}
			*/
		} catch (Exception e) {
			System.err.println("�����쳣������");
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