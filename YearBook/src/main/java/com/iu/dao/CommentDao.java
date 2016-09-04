package com.iu.dao;

import java.util.List;

import com.iu.model.Comment;
import com.iu.model.User;

public interface CommentDao {
	public void addComment(Comment comment);
	public void viewOwnComment(Comment comment);
	public List getOwnAllComments(User user);
	public List getAllUserComments(User user );
	public Comment edit(Comment comment);
	public void delete(Long comment_id);
	public Comment getComment(Long comment_id);
	Comment writeComment(Comment comment);
}
