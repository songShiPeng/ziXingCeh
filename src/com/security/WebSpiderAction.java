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
		//userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//���UserInfo����
		userInfos = (UserInfoSS)getUser();
		System.out.println("������showlistaction����Ҫ��ROLE_USER��ROLE_ADMINȨ�޲��ܷ���");
		return SUCCESS;
	}

	public String edittype(){
		System.out.println("������edittype��Ҫ��ROLE_USERȨ�޲��ܷ���");
		return SUCCESS;
	}

	public String savetype(){
		return SUCCESS;
	}

	public String deletetype(){
		//userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//���UserInfo����
		userInfos = (UserInfoSS)getUser();
		System.out.println("������deletetype��Ҫ��ROLE_ADMINȨ�޲��ܷ���");
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
