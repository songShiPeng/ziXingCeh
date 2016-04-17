package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.BaseAction;
import com.dao.BicycleinfoDAO;
import com.dao.BorrowRecordDAO;
import com.model.Bicycleinfo;
import com.model.Borrowrecord;
import com.security.UserInfoSS;
@Controller
public class BicycleAction extends BaseAction{
	//@Autowired
	private List<Bicycleinfo> bicycleList=new ArrayList<Bicycleinfo>();
	@Autowired
	private Bicycleinfo bicycleInfo;
	@Autowired
	private BicycleinfoDAO bicycleDao;
	
	
	public BicycleAction(){
		System.out.println("action构造");
	}
	
	//自行车管理页面
	@RequestMapping("/front/bicycleList.html")
	public ModelAndView bicycleList(){
		getUser();
		bicycleList=bicycleDao.getBicycleList();
		mv.addObject("bicycleList", bicycleList);
		mv.setViewName("front/bicycleList");
		
		return mv;
	}
	
	//自行车保存
	@RequestMapping("/front/saveBicycle.html")
	protected ModelAndView saveBicycle(Bicycleinfo bicycleInfo) {
		getUser();
		bicycleInfo.setBicycleState(0);
		bicycleDao.merge(bicycleInfo);
		bicycleList=bicycleDao.getBicycleList();
		mv.addObject("bicycleList", bicycleList);
		mv.setViewName("front/bicycleList");
		return mv;
	}
	
	//办理借车
			@RequestMapping("/front/bicycleEdit.html")
			protected ModelAndView bicycleEdit() {
				getUser();
				bicycleInfo=new Bicycleinfo();
				mv.addObject("bicycleInfo",bicycleInfo);
				mv.setViewName("front/bicycleEdit");
				return mv;
			}
	
}
