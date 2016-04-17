package com.security;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dao.UserInfoDAO;
import com.model.Userinfo;


public class LhUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	public static final String VALIDATE_CODE = "verifyCode";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	//private UserinfoDAO UserinfoDAO = new UserinfoDAO();

	@SuppressWarnings("unchecked")
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {

		UsernamePasswordAuthenticationToken authRequest;
		String error = "";
		try {
			String username = obtainUsername(request);
			String password = "";
			//��֤��У��
			if (checkValidateCode(request)) {
				
				UserInfoDAO UserinfoDAO = new UserInfoDAO();
				Userinfo Userinfo = new Userinfo();
				List tempUserList = new ArrayList();
				try {
					tempUserList = UserinfoDAO.findByName(
							username.trim());
				} catch (Exception e) {
					error = "δ�ҵ����ݷ���";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(
							request, response);
				}
				if (tempUserList != null && tempUserList.size() > 0) {
					Userinfo = (Userinfo) tempUserList.get(0);
					password = Userinfo.getPassword();
				} else {
					error = "��������˺Ż���������";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(
							request, response);
					throw new AuthenticationServiceException("�˺Ż��������");
				}
				String pass=obtainPassword(request)
						.trim();
				if (!password.equals(EncryptMD5.MD5(pass))) {
					error = "���������������";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(
							request, response);
					throw new AuthenticationServiceException("�������");
				}
				

				// UsernamePasswordAuthenticationTokenʵ�� Authentication
				authRequest = new UsernamePasswordAuthenticationToken(username,
						password);
				// ��������������ϸ����
				setDetails(request, authRequest);
				// ����UserDetailsService��loadUserByUsername �ٴη�װAuthentication
				return this.getAuthenticationManager()
						.authenticate(authRequest);
			} else {
				error = "���������֤������";
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request,
						response);				
				throw new AuthenticationServiceException("��֤������");
			}
		
		}catch (ServletException e) {
			throw new AuthenticationServiceException("��¼����");
		} catch (IOException e) {
			throw new AuthenticationServiceException("��¼����");
		}
	}

	// У����֤��ķ���
	protected boolean checkValidateCode(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionValidateCode = obtainSessionValidateCode(session);
		// ����һ�ε���֤��ʧЧ
		session.setAttribute(VALIDATE_CODE, null);
		String validateCodeParameter = obtainValidateCodeParameter(request);
		/**
		if (StringUtils.isEmpty(validateCodeParameter)
				|| !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
			//throw new AuthenticationServiceException("validateCode.notEquals");
			return  false;
		}else {
			return true;
		}
		**/
		return true;
	}

	private String obtainValidateCodeParameter(HttpServletRequest request) {
		Object obj = request.getParameter(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	protected String obtainSessionValidateCode(HttpSession session) {
		Object obj = session.getAttribute(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}

}
