package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.BaseAction;
import com.dao.UserInfoDAO;
import com.model.Userinfo;
@Controller
public class UserAction extends BaseAction{
	//@Autowired
	private List<Userinfo> userList=new ArrayList<Userinfo>();
	@Autowired
	private UserInfoDAO userDao;
	@Autowired
	private Userinfo userInfo;
	//@Autowired
	
	//用户管理页面
		@RequestMapping("/front/userList.html")
		public ModelAndView userList(){
			getUser();
			userList=userDao.getUserList();
			mv.addObject("userList", userList);
			mv.setViewName("front/userList");
			
			return mv;
		}
		
		//用戶保存
		@RequestMapping("/front/saveUser.html")
		protected ModelAndView saveUser(Userinfo userInfo) {
			 getUser();
			userInfo.setUserType("0");
			userInfo.setEnabled(0);
			userInfo.setAccountType(0);
			userInfo.setPassword("E10ADC3949BA59ABBE56E057F20F883E");
			userDao.merge(userInfo);
			userList=userDao.getUserList();
			mv.addObject("userList", userList);
			mv.setViewName("front/userList");
			return mv;
		}
		
		
		//用戶添加
			@RequestMapping("/front/userEdit.html")
			protected ModelAndView adUser() {
				getUser();
				userInfo=new Userinfo();
				mv.addObject("userInfo",userInfo);
				mv.setViewName("front/userEdit");
				return mv;
			}
}
