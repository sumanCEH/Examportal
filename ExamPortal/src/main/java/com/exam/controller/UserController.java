package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome Home";
	}
	
	
		//ADD new User using post mapping

		@PostMapping("/adduser")
		public User adduser(@RequestBody User user) throws Exception {
		
		Set<UserRole> roles = new HashSet<>();
		
		
		//new role object , and setRole and roleName
		Role role1 = new Role();
		role1.setRoleId(45l);
		role1.setRoleName("A4-EMPlOYEE");
		
		//new userRole object , and set  user and role object with userRole
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role1);
		
		//save userRole into a SET
		roles.add(userRole);
		
		//call userService and create user
		return this.userService.createUser(user, roles);
	
		}
	
	
		//get User by userName
		@GetMapping("/{username}")
		 public User getUser(@PathVariable("username")String username) throws Exception {
			 return this.userService.getUser(username);
		 }
	
		//delete User by id	
		@DeleteMapping("/{id}")
		public void deleteUser(@PathVariable("id") Long id) {
			this.userService.deleteUser(id);
		}
	
}
