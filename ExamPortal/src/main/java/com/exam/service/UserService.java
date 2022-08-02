package com.exam.service;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;

public interface UserService {

	//add User
	public User createUser(User user , Set<UserRole> userRoles) throws Exception;
	
	// getting user by userName
	public User getUser(String username);
	
	//delete user by user - id
	public void deleteUser(Long id);
}