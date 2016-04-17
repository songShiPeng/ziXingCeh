package com.common;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.security.UserInfoSS;


public class BaseAction {
	public UserInfoSS userInfoSS;
	public ModelAndView mv=new ModelAndView();
	
	
	public Object getUser(){
		userInfoSS = (UserInfoSS)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mv.clear();
		mv.addObject(userInfoSS);	
		return getUserInfoSS();		
	}
	
	
	//----------------get-------------set------------
	public UserInfoSS getUserInfoSS() {
		return userInfoSS;
	}
	public void setUserInfoSS(UserInfoSS userInfoSS) {
		this.userInfoSS = userInfoSS;
	}
}
