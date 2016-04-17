package com.security;

import java.util.List;

import javax.management.relation.RoleInfo;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.common.HibernateSessionFactory;
import com.dao.BaseDao;
import com.model.Userinfo;

public class SecurityDAO extends  BaseDao{

	

	public Userinfo findUserInfoByUserName(String userName) {
		Session session = HibernateSessionFactory.getSession();
		try {
			String hql = "from Userinfo where userName='" + userName + "'";
			Query queryObject = session.createQuery(hql);
			Userinfo userInfo = (Userinfo) queryObject.list().get(0);
			return userInfo;
		} catch (HibernateException e) {
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<RoleInfo> findRolesById(int id) {
		Session session = HibernateSessionFactory.getSession();
		try {
			String hql = "from RoleInfo where id='" + id + "'";
			Query queryObject = session.createQuery(hql);
			List roleList =  queryObject.list();
			return roleList;
		} catch (HibernateException e) {
			return null;
		} finally {
			session.close();
		}
	}

}
