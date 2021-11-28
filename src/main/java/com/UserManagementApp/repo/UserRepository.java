package com.UserManagementApp.repo;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.UserManagementApp.dto.User;

@Repository
public class UserRepository {

	List<User> userList=new ArrayList<>();
	
	
	
	public List<User> getAllUser() {
		return userList;
		
		
		
	}

	public User getUser(String id) {
		
		Optional<User>first=userList.stream().filter(user->user.getId().equals(id))
		.findFirst();
		
		if (first.isPresent()) {
			
			return first.get();
			
		}else {
			
			return new User();
		}
		
		 
	}

	public void addUser(User user) {
		
		userList.add(user);
		
		
	}

	public User updateUser(User user) {
		
		for (User users : userList) {
			
			if (users.getId().equals(user.getId())) {
				
				users.setName(user.getName());
				users.setAddress(user.getAddress());
				return users;
			}
		}
		return new User();
	}
	

	public User deleteUser(String id) {
		
		Optional<User>first=userList.stream().filter(user->user.getId().equals(id))
		.findFirst();
		
		if (first.isPresent()) {
			
			User user=first.get();
			userList.remove(user);
			return user;
			
		}else {
			
			return new User();
		}
		
	}

}
