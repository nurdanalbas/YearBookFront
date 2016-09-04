package com.iu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.dao.UserDao;
import com.iu.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory session;//veritabaný konfigürasyonu için oluþturulur.
	
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public User addUsers(User user) {
		return (User) session.getCurrentSession().merge(user);
	}
	
	@Override
	public User searchFriend(String username) {
		
		String sql = "select u from User u where u.name	= :userName";
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setParameter("userName", username);
		return (User) createQuery.uniqueResult();
	}
	
	@Override
	public User viewUserProfile(User user) {
		String sql = "select u from User u where u.id = :userId";
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setParameter("userId", user.getUserId());
		return (User) createQuery.uniqueResult();
	}
	
	
	@Override
	public User userCheck(User user) {
		String sql = "select u from User u where u.userMail = :userMail and u.password = :password";
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setParameter("userMail", user.getUserMail()); //// 
		createQuery.setParameter("password", user.getPassword()); //// 
		return (User) createQuery.uniqueResult();
	}
	
		
	@Override
	public User update(User user) {
		return (User) session.getCurrentSession().merge(user);
	}
	
	@Override
	public List getAllUsers() {
		return session.getCurrentSession().createQuery("select u from User u").list();
	}
	
	@Override
	public void delete(Long userId) {
		session.getCurrentSession().delete(getUser(userId));
	}
	
	@Override
	public User getUser(Long userId) {
		return (User) session.getCurrentSession().get(User.class, userId);
	}

	
	
}
