package com.example.Services;

import java.util.List;
import java.util.Optional;

import com.example.entities.InvoiceDetail;

public interface InvoiceManager {
	List<InvoiceDetail> getAllInvoiceDetails();
	Optional<InvoiceDetail> getInvoiceDetailById(Long id);
	InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail);
	void deleteInvoiceDetail(Long id);
}
