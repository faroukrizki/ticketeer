package com.azuralabs.ticketeer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azuralabs.ticketeer.entities.User;
import com.azuralabs.ticketeer.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user/new")
	public User createNewUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
