package com.UserManagementApp.service;

import java.util.List;


import com.UserManagementApp.dto.User;


public interface UserService {

	List<User> getAllUser();

	User getUser(String id);

	void addUser(User user);

	User updateUser(User user);

	User deleteUser(String id);


	

}
