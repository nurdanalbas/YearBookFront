package com.iu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_COMMENT")
public class Comment {
	
	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	comment_id;
	
	@Column(name = "NAME_SURNAME")
	private String	name_surName;
	
	@Column(name = "DESCRIPTION")
	private String	description;
	
	//yorum yapan
	@ManyToOne
	@JoinColumn(name = "USER_FROM_ID")
	private User	userFrom;
	
	//yorum yapýlan
	@ManyToOne
	@JoinColumn(name = "USER_TO_ID")
	private User	userTo;
	
	public Long getComment_id() {
		return comment_id;
	}
	
	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}
	
	public String getName_surName() {
		return name_surName;
	}
	
	public void setName_surName(String name_surName) {
		this.name_surName = name_surName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUserFrom() {
		return userFrom;
	}
	
	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}
	
	public User getUserTo() {
		return userTo;
	}
	
	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}
	
}
