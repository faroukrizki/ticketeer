package com.azuralabs.ticketeer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.azuralabs.ticketeer.entities.User;

public interface UserRepository extends CrudRepository<User, String>{

}
