package com.UserManagementApp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagementApp.dto.User;
import com.UserManagementApp.repo.UserRepository;
import com.UserManagementApp.service.UserService;

@Service
public class UserServiceImple implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<User> getAllUser() {
		
		return userRepository.getAllUser();
		
		
	}

	@Override
	public User getUser(String id) {
		
		return userRepository.getUser(id);
	}

	@Override
	public void addUser(User user) {
		
		 userRepository.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.updateUser(user);
	}

	@Override
	public User deleteUser(String id) {
		
		return userRepository.deleteUser(id);
	}

}
