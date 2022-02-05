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
import com.azuralabs.ticketeer.exceptions.InvoiceNotFoundException;
import com.azuralabs.ticketeer.exceptions.TicketNotFoundException;
import com.azuralabs.ticketeer.repositories.InvoiceRepository;
import com.azuralabs.ticketeer.repositories.TicketRepository;

@RestController
public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	@PostMapping("/create-invoice")
	Invoice createInvoice(@RequestBody Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	@PostMapping("/buy-tickets/{id}")
	Invoice addTickets(@RequestBody List<Ticket> tickets, @PathVariable Long id) {
		Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
		
		if(invoiceOptional.isEmpty()) {
			throw new InvoiceNotFoundException(id);
		}
		
		List<Ticket> ticketsAdded = new ArrayList<Ticket>();
		for(Ticket t: tickets) {
			Optional<Ticket> ticketOptional = ticketRepository.findById(t.getTicketId());
			if(ticketOptional.isEmpty()) {
				throw new TicketNotFoundException(t.getTicketId());
			}
			ticketsAdded.add(ticketOptional.get());
		}
		
		ticketRepository.saveAll(ticketsAdded);
		return invoiceOptional.get();
	}
}
