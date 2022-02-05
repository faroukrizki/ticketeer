package com.azuralabs.ticketeer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.azuralabs.ticketeer.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
}
