package com.azuralabs.ticketeer.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.azuralabs.ticketeer.exceptions.InvoiceNotFoundException;

@ControllerAdvice
public class InvoiceNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(InvoiceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String invoiceNotFoundHandler(InvoiceNotFoundException e) {
		return e.getMessage();
	}
}
