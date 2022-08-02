package com.exam.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepo;
import com.exam.repository.UserRepo;
import com.exam.service.UserService;


@Service

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	
	
	// user service Implementation

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		//check same user ..... and create a "findByUserName" function -----> in UserRepo  
		User local = this.userRepo.findByUsername(user.getUsername());

		if (local != null) {

		System.out.println("User is already there !!"); 
		throw new Exception("failed");
		} 
		
		else{

		//user create
			//here can be two and more roles , here using for loop we are save 1 role 
			
		for (UserRole ur:userRoles)

		{

		roleRepo.save(ur.getRole());

		}

		//because user and userRole are different . so we are here ---> user + userRoles 
		user.getUserRoles ().addAll(userRoles);
		//call userRepo and save user and save into local .. return local  
		local = this.userRepo.save(user); 

		}

				
				return local;
			}

    	//Get User by UserName
	
		@Override
		public User getUser(String username) {
			return this.userRepo.findByUsername(username);
		}

	}