package com.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.model.Borrowrecord;

@Component
public class BorrowRecordDAO extends BaseDao {
	public BorrowRecordDAO (){
		System.out.println("被构造");
	}
	
	public List<Borrowrecord> getBorrowrecordList(){
		
		try{
			String hql="from Borrowrecord";
			List list=this.findByHql(hql);
			return list;
		}catch(Exception e){
			return null;
		}
	}
	
	public List<Borrowrecord> getBorrowrecordListByBicycle(String bicycleName){
		
		try{
			String hql="from Borrowrecord where bicycleName ='"+bicycleName+"' and isReturn='0'";
			List list=this.findByHql(hql);
			return list;
		}catch(Exception e){
			return null;
		}
	}
	//根据id得到记录
	public Borrowrecord getRecordById(int id){
		String hql="from Borrowrecord where id = '"+id+"'";
		List list=this.findByHql(hql);
		if(list.size()>0)
			return (Borrowrecord) list.get(0);
		else 
			return null;
	}
	
	public boolean canBorrowBicycle(String bicycleName){
		String hql="from Borrowrecord where bicycleName = '"+bicycleName+"' and isReturn='0'";
		List list=this.findByHql(hql);
		if(list.size()>0)
			return false;
		else 
			return true;
	}
	
	public boolean canBorrowUser(String userName){
		String hql="from Borrowrecord where userName = '"+userName+"' and isReturn='0'";
		List list=this.findByHql(hql);
		if(list.size()>0)
			return false;
		else 
			return true;
	}
}