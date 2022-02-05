package com.azuralabs.ticketeer.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azuralabs.ticketeer.entities.Invoice;
import com.azuralabs.ticketeer.entities.Ticket;
import com.azuralabs.ticketeer.entities.User;
import com.azuralabs.ticketeer.exceptions.InvoiceNotFoundException;
import com.azuralabs.ticketeer.exceptions.TicketNotFoundException;
import com.azuralabs.ticketeer.exceptions.UserNotFoundException;
import com.azuralabs.ticketeer.repositories.InvoiceRepository;
import com.azuralabs.ticketeer.repositories.TicketRepository;
import com.azuralabs.ticketeer.repositories.UserRepository;

@RestController
public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/invoice/create/{username}")
	public Invoice createNewInvoice(@RequestBody List<Ticket> tickets, @PathVariable String username) {
		Optional<User> userOptional = userRepository.findById(username);
		
		if(userOptional.isEmpty()) {
			throw new UserNotFoundException(username);
		}
		
		User user = userOptional.get();
		
		List<Ticket> ticketList = new ArrayList<Ticket>();
		
		for(Ticket t: tickets) {
			Optional<Ticket> ticket = ticketRepository.findById(t.getTicketId());
			
			if(ticket.isEmpty()) {
				throw new TicketNotFoundException(t.getTicketId());
			}
			
			ticketList.add(ticket.get());
		}
		
		Invoice invoice = new Invoice();
		invoice.setUser(user);		
		invoice = invoiceRepository.save(invoice);
		
		for(Ticket t: ticketList) {
			t.setInvoice(invoice);
			ticketRepository.save(t);
		}
		
		return invoice;
	}
}
