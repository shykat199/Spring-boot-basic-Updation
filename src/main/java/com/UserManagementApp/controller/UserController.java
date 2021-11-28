package com.UserManagementApp.controller;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.UserManagementApp.dto.User;
import com.UserManagementApp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	
	@GetMapping("/user")
	public List<User> getAllUser() {
		
		return service.getAllUser();
	}
	
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable String id) {
		
		return service.getUser(id);
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User user ) {
		
		service.addUser(user);
		
		URI pathUri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(pathUri).build();
	}
	
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		
		return service.updateUser(user);
		
	}
	
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable String id) {
		
		return service.deleteUser(id);
		
	}
	
}
