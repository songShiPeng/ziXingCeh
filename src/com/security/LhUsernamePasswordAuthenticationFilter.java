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
			//验证码校验
			if (checkValidateCode(request)) {
				
				UserInfoDAO UserinfoDAO = new UserInfoDAO();
				Userinfo Userinfo = new Userinfo();
				List tempUserList = new ArrayList();
				try {
					tempUserList = UserinfoDAO.findByName(
							username.trim());
				} catch (Exception e) {
					error = "未找到数据服务";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(
							request, response);
				}
				if (tempUserList != null && tempUserList.size() > 0) {
					Userinfo = (Userinfo) tempUserList.get(0);
					password = Userinfo.getPassword();
				} else {
					error = "您输入的账号或密码有误";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(
							request, response);
					throw new AuthenticationServiceException("账号或密码错误！");
				}
				String pass=obtainPassword(request)
						.trim();
				if (!password.equals(EncryptMD5.MD5(pass))) {
					error = "您输入的密码有误";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(
							request, response);
					throw new AuthenticationServiceException("密码错误！");
				}
				

				// UsernamePasswordAuthenticationToken实现 Authentication
				authRequest = new UsernamePasswordAuthenticationToken(username,
						password);
				// 允许子类设置详细属性
				setDetails(request, authRequest);
				// 运行UserDetailsService的loadUserByUsername 再次封装Authentication
				return this.getAuthenticationManager()
						.authenticate(authRequest);
			} else {
				error = "您输入的验证码有误";
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request,
						response);				
				throw new AuthenticationServiceException("验证码有误");
			}
		
		}catch (ServletException e) {
			throw new AuthenticationServiceException("登录出错");
		} catch (IOException e) {
			throw new AuthenticationServiceException("登录出错");
		}
	}

	// 校验验证码的方法
	protected boolean checkValidateCode(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionValidateCode = obtainSessionValidateCode(session);
		// 让上一次的验证码失效
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
