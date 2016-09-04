package com.iu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iu.Result;
import com.iu.model.User;
import com.iu.model.UserToken;
import com.iu.service.UserTokenService;

@RestController
@RequestMapping(value = "userToken")
public class UserTokenController {
	
	@Autowired
	private UserTokenService userTokenService;
	
		
	@RequestMapping(method = RequestMethod.POST, value = { "/userCheck" })
	public @ResponseBody String userCheck(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(body, User.class);
		
		if ((user.getUserMail() != null) & (user.getPassword() != null)) {
			System.out.println(user.getUserId());
			Result result = userTokenService.userCheck(user);
			
			String writeValueAsString = objectMapper.writeValueAsString(result);
			return writeValueAsString;
			
		} else {
			Result result = new Result();
			result.setError(true);
			result.setMessage("username boþ olamazç");
			String writeValueAsString = objectMapper.writeValueAsString(result);
			return writeValueAsString;
		}
	}
	
    
	@RequestMapping(method = RequestMethod.POST, value = { "/tokenInfo" })
	public @ResponseBody String tokenInfo(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		UserToken userToken = objectMapper.readValue(body, UserToken.class);
		
		if ((userToken != null) & (userToken.getToken() != null)) {
			Result result = userTokenService.tokenInfo(userToken);
			
			String writeValueAsString = objectMapper.writeValueAsString(result);
			return writeValueAsString;
			
		} else {
			Result result = new Result();
			result.setError(true);
			result.setMessage("Token Bulunamadý");
			String writeValueAsString = objectMapper.writeValueAsString(result);
			return writeValueAsString;
		}
	}
	
	
	
	
	
	
	
	
	

}
