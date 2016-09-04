package com.iu.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.dao.UserTokenDao;
import com.iu.model.UserToken;

@Repository
public class UserTokenDaoImpl implements UserTokenDao {

	// veritabaný konfigürasyonu için oluþturulur.
	@Autowired
	private SessionFactory session;
	
	public UserTokenDaoImpl() {
	}

	@Override
	public UserToken save(UserToken user) {
		return (UserToken) session.getCurrentSession().merge(user);
	}

	@Override
	public UserToken update(UserToken user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserToken delete(UserToken user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserToken tokenInfo(UserToken user){
		String sql = "select u from UserToken u where u.token = :token";
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setParameter("token",user.getToken());
		return (UserToken) createQuery.uniqueResult();
	}
	
	
}
