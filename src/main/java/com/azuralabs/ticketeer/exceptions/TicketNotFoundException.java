package com.azuralabs.ticketeer.exceptions;

public class TicketNotFoundException extends RuntimeException {
	
	public TicketNotFoundException(Long id){
		super("Couldn't find ticket with id "+ id);
	}
	
}
