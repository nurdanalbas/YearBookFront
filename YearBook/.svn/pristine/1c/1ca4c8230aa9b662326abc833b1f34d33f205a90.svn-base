package com.iu.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iu.Result;
import com.iu.dao.UserTokenDao;
import com.iu.model.User;
import com.iu.model.UserToken;

@Service
public class UserTokenService {

	@Autowired
	private UserTokenDao userTokenDao;

	@Autowired
	UserService userService;

	@Transactional
	public Result userCheck(User user) {
		Result result = new Result();
		User userCheck = userService.userCheck(user);

		if (userCheck != null) {
			String token = UUID.randomUUID().toString();

			UserToken userToken = new UserToken();
			userToken.setUser(userCheck);
			userToken.setToken(token);
			userToken = userTokenDao.save(userToken);

			result.setData(userToken);
			result.setError(false);

			return result;
		} else {
			result.setData(null);
			result.setMessage("Check Your Mail or Password");
			result.setData(null);
			result.setError(true);
			return result;
		}
	}
   

	@Transactional
	public Result tokenInfo(UserToken user) {
		Result result = new Result();
		UserToken tokenInfo = userTokenDao.tokenInfo(user); //databaseden bilgileri getiren kýsým

		if (tokenInfo != null) {
			result.setData(tokenInfo);
			result.setError(false);

			return result;
		} else {
			result.setMessage("Token Bulunamadý.");
			result.setData(null);
			result.setError(true);
			return result;
		}
	}

}
