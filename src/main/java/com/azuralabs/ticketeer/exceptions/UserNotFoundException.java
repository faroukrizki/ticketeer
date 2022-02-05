package com.azuralabs.ticketeer.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String username) {
		super("Couldn't find user with the username "+username);
	}
}
