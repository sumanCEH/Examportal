package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRole_id;
	
	
	//mapping with user
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	//mapping with role
	@ManyToOne
	private Role role;

	
	//without fields constructor
	public UserRole() {
		super();
	}


	//getter setter
	
	public long getUserRole_id() {
		return userRole_id;
	}


	public void setUserRole_id(long userRole_id) {
		this.userRole_id = userRole_id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
