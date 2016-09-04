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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iu.model.Comment;
import com.iu.model.User;
import com.iu.service.CommentService;

@RestController
@RequestMapping(value = "comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	public CommentController() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "/bugun" })
	public @ResponseBody String bugun(@RequestBody String map, HttpServletRequest request) {
		return "Date" + new Date();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/list")
	public @ResponseBody String list(@RequestBody String body) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(body, User.class);
		List allComments = commentService.getAllUserComments(user);
		String writeValueAsString = objectMapper.writeValueAsString(allComments);
		return writeValueAsString;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "/add" })
	public @ResponseBody String add(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Comment comment = objectMapper.readValue(body, Comment.class);
		System.out.println(comment);
		
		return "";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "/edit" })
	public @ResponseBody String edit(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Comment comment = objectMapper.readValue(body, Comment.class);
		
		if (comment.getComment_id() != null) {
			System.out.println(comment.getComment_id());
			comment=commentService.edit(comment);
			String writeValueAsString = objectMapper.writeValueAsString(comment);
			return writeValueAsString;
			
		} else {
			System.out.println("Error!!!");
		}
		return " ";
	}
	@RequestMapping(method = RequestMethod.POST, value = { "/delete" })
	public @ResponseBody String delete(@RequestBody String body, HttpServletRequest request) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Comment comment = objectMapper.readValue(body, Comment.class);
		
		Long comment_id = comment.getComment_id();
		if ( comment_id != null) {
			System.out.println(comment_id);
			commentService.delete(comment_id);
			return "Deleted.";
		} else {
			System.out.println("Error!!!");
		}
		return " ";
	}
		

}
