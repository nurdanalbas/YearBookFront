package com.iu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.dao.CommentDao;
import com.iu.model.Comment;
import com.iu.model.User;

@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SessionFactory session;
	
	public CommentDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addComment(Comment comment) {
		
		session.getCurrentSession().save(comment);
		
	}
	
	@Override
	public void viewOwnComment(Comment comment) {
		
		String sql = "select c from Comment c where c.id = :commentId";
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setParameter("commentId", comment.getComment_id());
		
	}
	
	@Override
	public List getOwnAllComments(User user) {//yorum yapýlan kiþi comment written to friend
		String sql = "select c from Comment c where c.userTo = :userTo";
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setParameter("userTo", user);
		return createQuery.list();
		
	}
	
	@Override
	public List getAllUserComments(User user) {
		String sql = "select c from Comment c where c.userFrom = :userFrom";
		Query createQuery = session.getCurrentSession().createQuery(sql);
		createQuery.setParameter("userFrom", user);
		return createQuery.list();
	}
	
	@Override
	public Comment writeComment(Comment comment) {
		return (Comment) session.getCurrentSession().merge(comment);
	}
	
	@Override
	public Comment edit(Comment comment) {
		return (Comment) session.getCurrentSession().merge(comment);
	}
	
	@Override
	public void delete(Long comment_id) {
		session.getCurrentSession().delete(comment_id);
	}
	
	@Override
	public Comment getComment(Long comment_id) {
		return (Comment) session.getCurrentSession().get(Comment.class, comment_id);
	}
}
