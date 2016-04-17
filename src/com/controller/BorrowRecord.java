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

	//�賵��¼ҳ��
	@RequestMapping("/front/borrowrecordList.html")
	public ModelAndView borrowrecordList(){
		getUser();
		borrowrecordList=borrowRecordInfoDao.getBorrowrecordList();
		mv.addObject("borrowrecordList", borrowrecordList);
		mv.setViewName("front/borrowrecordList");
		
		return mv;
	}
	//���ݳ�����ҵ���¼�б�
	@RequestMapping("/front/saveReturnBicycle.html")
	public ModelAndView saveReturnBicycle(Bicycleinfo bicycleInfo){
		getUser();
		borrowrecordList=borrowRecordInfoDao.getBorrowrecordListByBicycle(bicycleInfo.getBicycleNumber());
		mv.addObject("borrowrecordList", borrowrecordList);
		mv.setViewName("front/borrowrecordList");
		
		return mv;
	}
	//����
		@RequestMapping("/front/returnBicycleByTop.html")
		public ModelAndView returnBicycleByTop(){
			getUser();
			bicycleInfo=new Bicycleinfo();
			mv.addObject("bicycleInfo",bicycleInfo);
			mv.setViewName("front/returnBicycle");
			return mv;
		}
	
	//���г�����
	@RequestMapping("/front/saveBorrowrecord.html")
	protected ModelAndView saveBorrowrecord(Borrowrecord borrowRecordInfo) {
		getUser();
		borrowRecordInfo.setIsReturn(0);
		Date date = new Date();
		String messege="";
		if(!bicycleDao.canBorrow(borrowRecordInfo.getBicycleName())){
			messege+="û�д˳���! ";
		}
		else if(!borrowRecordInfoDao.canBorrowBicycle(borrowRecordInfo.getBicycleName())){
			messege+="�����ѱ����! ";
		}
		if(!userDao.canBorrow(borrowRecordInfo.getUserName())){
			messege+="û�д��û� !";
		}
		if(!borrowRecordInfoDao.canBorrowUser(borrowRecordInfo.getUserName())){
			messege+="���û�δ���� !";
		}
		mv.addObject("messege",messege);
		if(messege.length()>1){
			mv.setViewName("front/borrowrecordEdit");			
			mv.addObject("borrowRecordInfo",borrowRecordInfo);
			return mv;
		}
		String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(date);//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
		borrowRecordInfo.setBorrowTime(nowTime);
		
		borrowRecordInfoDao.merge(borrowRecordInfo);
		borrowrecordList=borrowRecordInfoDao.getBorrowrecordList();
		mv.addObject("borrowrecordList", borrowrecordList);
		mv.setViewName("front/borrowrecordList");
		return mv;
	}
	
	
	//����賵
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
		//������
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
