package com.dao;

import java.util.List;

import com.model.Userinfo;


public class UserInfoDAO extends BaseDao {
	
	
	public List<Userinfo> getUserList(){
		
		try{
			String hql="from Userinfo";
			List list=this.findByHql(hql);
			return list;
		}catch(Exception e){
			return null;
		}
	}
	
	public List<Userinfo> findByName(String name){
		
		try{
			String hql="from Userinfo where userName ='"+name+"'";
			List list=this.findByHql(hql);
			return list;
		}catch(Exception e){
			return null;
		}
	}
	
	public Userinfo getUserById(int name){
		
		try{
			String hql="from Userinfo where id ='"+name+"'";
			List list=this.findByHql(hql);
			if(list.size()>0)
				return  (Userinfo) list.get(0);
			else
				return null;
		}catch(Exception e){
			return null;
		}
	}
	

	public boolean canBorrow(String userName){
		
		try{
			String hql="from Userinfo where userName ='"+userName+"'";
			List list=this.findByHql(hql);
			if(list.size()>0)
				return  true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}
	
}