package com.iu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iu.dao.CommentDao;
import com.iu.model.Comment;
import com.iu.model.User;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Transactional
	public void addComment(Comment comment) {
		commentDao.addComment(comment);
	}
	
	
	@Transactional
	public void viewOwnComment(Comment comment) {
		commentDao.viewOwnComment(comment);
	}
	
	
	@Transactional
	public List getOwnAllComments(User user) {
		
		return commentDao.getOwnAllComments(user);
	}
	
	
	@Transactional
	public List getAllUserComments(User user) {
		
		return commentDao.getAllUserComments(user);
	}
	
	
	@Transactional
	public Comment writeComment(Comment comment) {
		
		return commentDao.writeComment(comment);	
		}
	@Transactional
	public Comment edit(Comment comment){
		return commentDao.edit(comment);
	}
	@Transactional
	public void delete(Long comment_id){
		commentDao.delete(comment_id);
	}
	
}
