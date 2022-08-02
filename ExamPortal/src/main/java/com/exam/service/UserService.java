package com.exam.service;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;

public interface UserService {

	//creating User
	
	public User CreateUser(User user , Set<UserRole> userRoles) throws Exception;
	
	
}