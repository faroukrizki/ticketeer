package com.azuralabs.ticketeer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azuralabs.ticketeer.entities.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
