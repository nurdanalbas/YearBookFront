package com.iu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iu.dao.UserDao;
import com.iu.model.User;

@Service
public class UserService{

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public User addUsers(User user) {
		
		return userDao.addUsers(user);
		
	}

	@Transactional
	public User searchFriend(String username) {
		return userDao.searchFriend(username);
	}

	@Transactional
	public User viewUserProfile(User user) {
		return userDao.viewUserProfile(user);
	}

	@Transactional
	public User update(User user) {
	
		return userDao.update(user);
	}

	@Transactional
	public List getAllUsers() {

		return userDao.getAllUsers();

	}

	@Transactional
	public void delete(Long userId) {
	
		userDao.delete(userId);

	}

	@Transactional
	public User getUser(Long userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public User userCheck(User user) {
		
		return userDao.userCheck(user);
	}

}
