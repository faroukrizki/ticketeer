package com.azuralabs.ticketeer.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azuralabs.ticketeer.entities.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

	@Query("SELECT SUM(t.price) FROM Ticket t WHERE t.invoice.invoiceId = ?1 AND t.invoice.user.username = ?2")
	public BigDecimal getTotal(Long invoiceId, String username);
}
