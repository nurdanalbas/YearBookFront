package com.iu.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iu.Result;
import com.iu.model.User;
import com.iu.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	//second commit
	//thirdcommit
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = { "/user.html" })
	public String user(HttpServletRequest request) {
		return "test";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "/bugun" })
	public @ResponseBody String bugun(@RequestBody String map, HttpServletRequest request) {
		return "Date" + new Date();
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/getUser")
	public @ResponseBody String getUser(@RequestBody String body) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(body, User.class);
		
		if ((user.getUserId() != null)) {
			System.out.println(user.getUserId());
			Long userId = user.getUserId();
			User user2 = userService.getUser(userId);
			Result result = new Result();
			result.setData(user2);
			String writeValueAsString = objectMapper.writeValueAsString(result);
			return writeValueAsString;
			
		} else {
			Result result = new Result();
			result.setError(true);
			result.setMessage("profile ulaþýlamýyor.");
			String writeValueAsString = objectMapper.writeValueAsString(result);
			return writeValueAsString;
		}
				}
	
//	@RequestMapping(method = RequestMethod.POST, value = { "/asd" }, consumes = { "application/json" }, produces = { "application/json" })
//	public @ResponseBody Map<String, String> asd(@RequestBody Map<String, String> map, HttpServletRequest request) {
//		return map;
//	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = { "/list" })
	public @ResponseBody String list(@RequestBody String body) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		List allUsers = userService.getAllUsers();
		String writeValueAsString = objectMapper.writeValueAsString(allUsers);
		return writeValueAsString;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "/add" })
	public @ResponseBody String add(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(body, User.class);
		User addedUser = userService.addUsers(user);
		String writeValueAsString = objectMapper.writeValueAsString(addedUser);
		return writeValueAsString;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "/edit" })
	public @ResponseBody String edit(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(body, User.class);
		
		if (user.getUserId() != null) {
			System.out.println(user.getUserId());
			user = userService.update(user);
			String writeValueAsString = objectMapper.writeValueAsString(user);
			return writeValueAsString;
			
		} else {
			System.out.println("Error!!!");
		}
		return " ";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "/delete" })
	public @ResponseBody String delete(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(body, User.class);
		
		Long userId = user.getUserId();
		if (userId != null) {
			System.out.println(userId);
			userService.delete(userId);
			return "Deleted.";
		} else {
			System.out.println("Error!!!");
		}
		return " ";
	}
	//user al 
	@RequestMapping(method = RequestMethod.POST, value = "/search")
	public @ResponseBody String search(@RequestBody String body) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(body, User.class);
		List allUsers = userService.searchFriend(user);
	    
		
		String writeValueAsString = objectMapper.writeValueAsString(user);
		return writeValueAsString;
				}
	
	
}

/**
	 * duzenle
	 * listele
	 * sil
	 */
