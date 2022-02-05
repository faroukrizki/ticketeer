package com.azuralabs.ticketeer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azuralabs.ticketeer.entities.Ticket;
import com.azuralabs.ticketeer.repositories.TicketRepository;

@RestController
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;
	
	@PostMapping("/ticket/new")
	public Ticket createNewTicket(@RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
}
