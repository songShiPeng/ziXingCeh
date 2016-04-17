package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.common.HibernateSessionFactory;


public class BaseDao {
	
	
	//保存
	public int merge(Object detachedInstance) {
		org.hibernate.Session session=getSession();
		Transaction ta=session.beginTransaction();
		try {
			session.merge(detachedInstance);
			ta.commit();
			session.close();
			return 0;
		} catch (RuntimeException re) {
			if(ta!=null)
				ta.rollback();
			session.close();
			return 1;		}
	}
	
	//根据hql得到list
	public List<Object> findByHql(String hql){
		Session session=HibernateSessionFactory.getSession();
		try{
			Query qr=session.createQuery(hql);
			List list=qr.list();
			return list;
		}catch(Exception e){
			return null;
		}
		finally{
			session.close();
		}
	}
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}

