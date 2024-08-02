package com.example.Services;

import java.util.List;
import java.util.Optional;

import com.example.entities.InvoiceHeader;

public interface InvoiceHeaderManager {
	void deleteInvoiceHeader(Long id);
	List<InvoiceHeader> getAllInvoiceHeaders();
	Optional<InvoiceHeader> getInvoiceHeaderById(Long id);
	InvoiceHeader saveInvoiceHeader(InvoiceHeader invoiceHeader);
}
