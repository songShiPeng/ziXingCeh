package com.security;



import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


//�ж��û��Ƿ������������Դ����Ҫ�Ľ�ɫȨ��
public class LhAccessDecisionManager implements AccessDecisionManager {

	private boolean isThrough = true;//���û������з���������Դ��Ȩ��ʱ������ͨ�����ǽ�ֹͨ��
	private SecurityDAO securityDAO = new SecurityDAO();
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;//�����ɫ�б�Ϊ������У��൱��ϵͳ����������Դ���ð�ȫ����
		}
		/*�˴��ſ�ƽ̨����Ա��ʹ����Թۿ���������*/
		Collection<GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : grantedAuthorities) {
			if (grantedAuthority.getAuthority().equals("ƽ̨����Ա")) {
				return;
			}
		}
		/*end �ſ�����Ա*/

		// ��Ӧ������Դ��ϵͳ���н�ɫȨ��
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();//configAttributes��LhSecurityMetadataSource�õ�
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			// ������������Դ����Ҫ�Ľ�ɫȨ��
			String needPermission = configAttribute.getAttribute();
			//System.out.println("������������Դ����Ҫ��Ȩ��needPermission is " + needPermission);

			// �û���ӵ�е�Ȩ��authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {//authentication��LhUserDetailsService�õ�
				//System.out.println("�û���ӵ�е�Ȩ��ga.getAuthority():" + ga.getAuthority());
				if (needPermission.equalsIgnoreCase(ga.getAuthority())) {// �����ִ�Сд����security��xml�ļ����ɫ��Ȼ���ִ�Сд
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
		if (isThrough) {//�൱��û�а�ȫ����
			return;
		}else {//û�н�ɫȨ�޽�ֹ����
			// û��Ȩ���׳��쳣,��ֹ����
			throw new AccessDeniedException(" û��Ȩ�޷��ʣ�");
		}	

	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
