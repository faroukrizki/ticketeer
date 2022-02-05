package com.azuralabs.ticketeer.exceptions;

public class InvoiceNotFoundException extends RuntimeException {
	
	public InvoiceNotFoundException(Long id) {
		super("Couldn't find invoice with id "+id);
	}
}
