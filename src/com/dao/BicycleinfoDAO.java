package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.common.HibernateSessionFactory;
import com.model.Bicycleinfo;


public class BicycleinfoDAO extends BaseDao {
	public BicycleinfoDAO (){
		System.out.println("������");
	}
	
	public List<Bicycleinfo> getBicycleList(){
		
		try{
			String hql="from Bicycleinfo";
			List list=this.findByHql(hql);
			return list;
		}catch(Exception e){
			return null;
		}
	}
	//����id�õ���Ϣ
	public Bicycleinfo getBicycleById(int id){
		
		try{
			String hql="from Bicycleinfo where id ='"+id+"'";
			List list=this.findByHql(hql);
			if(list.size()>0)
				return (Bicycleinfo) list.get(0);
			else 
				return null;
		}catch(Exception e){
			return null;
		}
	}
	
	//����Ƿ�ɽ�
		public boolean canBorrow(String bicycleName){
			
			try{
				String hql="from Bicycleinfo where bicycleNumber ='"+bicycleName+"'";
				List list=this.findByHql(hql);
				if(list.size()>0)
					return true;
				else 
					return false;
			}catch(Exception e){
				return false;
			}
		}
	
}