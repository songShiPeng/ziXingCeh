package com.security;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;


import com.jxzc.common.BaseSupportAction;
import com.opensymphony.xwork2.ActionSupport;



public class WebSpiderAction extends BaseSupportAction{
	

	private Integer id;
	private UserInfoSS userInfos;
	
	
	

	public String showWebList(){
		//userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获得UserInfo对象
		userInfos = (UserInfoSS)getUser();
		System.out.println("这里是showlistaction，需要有ROLE_USER，ROLE_ADMIN权限才能访问");
		return SUCCESS;
	}

	public String edittype(){
		System.out.println("这里是edittype需要有ROLE_USER权限才能访问");
		return SUCCESS;
	}

	public String savetype(){
		return SUCCESS;
	}

	public String deletetype(){
		//userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获得UserInfo对象
		userInfos = (UserInfoSS)getUser();
		System.out.println("这里是deletetype需要有ROLE_ADMIN权限才能访问");
		return SUCCESS;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfoSS getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(UserInfoSS userInfos) {
		this.userInfos = userInfos;
	}

}
