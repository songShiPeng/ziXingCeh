package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.BaseAction;
import com.dao.BicycleinfoDAO;
import com.dao.BorrowRecordDAO;
import com.dao.UserInfoDAO;
import com.model.Bicycleinfo;
import com.model.Borrowrecord;
import com.model.Userinfo;
@Controller
public class BorrowRecord extends BaseAction{
	//@Autowired
	private List<Borrowrecord> borrowrecordList=new ArrayList<Borrowrecord>();
	
	private Borrowrecord borrowRecordInfo=new Borrowrecord();
	@Autowired
	private BorrowRecordDAO borrowRecordInfoDao;
	private BicycleinfoDAO bicycleDao=new BicycleinfoDAO();
	private Bicycleinfo bicycleInfo;
	private UserInfoDAO userDao =new UserInfoDAO();
	private Userinfo userInfo;

	//借车记录页面
	@RequestMapping("/front/borrowrecordList.html")
	public ModelAndView borrowrecordList(){
		getUser();
		borrowrecordList=borrowRecordInfoDao.getBorrowrecordList();
		mv.addObject("borrowrecordList", borrowrecordList);
		mv.setViewName("front/borrowrecordList");
		
		return mv;
	}
	//根据车编号找到记录列表
	@RequestMapping("/front/saveReturnBicycle.html")
	public ModelAndView saveReturnBicycle(Bicycleinfo bicycleInfo){
		getUser();
		borrowrecordList=borrowRecordInfoDao.getBorrowrecordListByBicycle(bicycleInfo.getBicycleNumber());
		mv.addObject("borrowrecordList", borrowrecordList);
		mv.setViewName("front/borrowrecordList");
		
		return mv;
	}
	//还车
		@RequestMapping("/front/returnBicycleByTop.html")
		public ModelAndView returnBicycleByTop(){
			getUser();
			bicycleInfo=new Bicycleinfo();
			mv.addObject("bicycleInfo",bicycleInfo);
			mv.setViewName("front/returnBicycle");
			return mv;
		}
	
	//自行车保存
	@RequestMapping("/front/saveBorrowrecord.html")
	protected ModelAndView saveBorrowrecord(Borrowrecord borrowRecordInfo) {
		getUser();
		borrowRecordInfo.setIsReturn(0);
		Date date = new Date();
		String messege="";
		if(!bicycleDao.canBorrow(borrowRecordInfo.getBicycleName())){
			messege+="没有此车辆! ";
		}
		else if(!borrowRecordInfoDao.canBorrowBicycle(borrowRecordInfo.getBicycleName())){
			messege+="车辆已被借出! ";
		}
		if(!userDao.canBorrow(borrowRecordInfo.getUserName())){
			messege+="没有此用户 !";
		}
		if(!borrowRecordInfoDao.canBorrowUser(borrowRecordInfo.getUserName())){
			messege+="该用户未还车 !";
		}
		mv.addObject("messege",messege);
		if(messege.length()>1){
			mv.setViewName("front/borrowrecordEdit");			
			mv.addObject("borrowRecordInfo",borrowRecordInfo);
			return mv;
		}
		String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(date);//将时间格式转换成符合Timestamp要求的格式.
		borrowRecordInfo.setBorrowTime(nowTime);
		
		borrowRecordInfoDao.merge(borrowRecordInfo);
		borrowrecordList=borrowRecordInfoDao.getBorrowrecordList();
		mv.addObject("borrowrecordList", borrowrecordList);
		mv.setViewName("front/borrowrecordList");
		return mv;
	}
	
	
	//办理借车
		@RequestMapping("/front/borrowrecordEdit.html")
		protected ModelAndView addBorrowRecord(int bicycleId,int userId) {
			getUser();
			borrowRecordInfo=new Borrowrecord();
			if(bicycleId!=0){
				bicycleInfo=bicycleDao.getBicycleById(bicycleId);
				borrowRecordInfo.setBicycleId(bicycleId);
				borrowRecordInfo.setBicycleName(bicycleInfo.getBicycleNumber());
			}
			if(userId!=0){
				userInfo=(Userinfo) userDao.getUserById(userId);
				borrowRecordInfo.setUserId(userId);
				borrowRecordInfo.setUserName(userInfo.getUserName());
			}
			mv.addObject("borrowRecordInfo",borrowRecordInfo);
			mv.setViewName("front/borrowrecordEdit");
			return mv;
		}
		//办理还车
		@RequestMapping("/front/returnBicycle.html")
		protected ModelAndView returnBicycle(int id) {
			getUser();
			borrowRecordInfo=borrowRecordInfoDao.getRecordById(id);
			if(borrowRecordInfo!=null){
				borrowRecordInfo.setIsReturn(1);
			}
			borrowRecordInfoDao.merge(borrowRecordInfo);
			borrowrecordList=borrowRecordInfoDao.getBorrowrecordList();
			mv.addObject("borrowrecordList", borrowrecordList);
			mv.setViewName("front/borrowrecordList");
			return mv;
		}
}
