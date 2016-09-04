package com.iu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_USER_TOKEN")
@JsonIgnoreProperties
public class UserToken {
	@Id
	@Column(name = "USERTOKEN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	id;
	
	@ManyToOne // x to x olan joincolumn olur
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column(name = "TOKEN")
	private String token;

	public UserToken(){
		
	}

	public UserToken(Long id, User user, String token) {
		super();
		this.id = id;
		this.user = user;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	


	
}
