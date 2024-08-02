package com.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entities.InvoiceHeader;
import com.example.repositories.InvoiceHeaderRepository;

@Service
public class InvoiceHeaderManagerImpl implements InvoiceHeaderManager {

    @Autowired
    private InvoiceHeaderRepository invoiceHeaderRepository;

    public List<InvoiceHeader> getAllInvoiceHeaders() {
        return invoiceHeaderRepository.findAll();
    }

    public Optional<InvoiceHeader> getInvoiceHeaderById(Long id) {
        return invoiceHeaderRepository.findById(id);
    }

    public InvoiceHeader saveInvoiceHeader(InvoiceHeader invoiceHeader) {
        return invoiceHeaderRepository.save(invoiceHeader);
    }

    public void deleteInvoiceHeader(Long id) {
        invoiceHeaderRepository.deleteById(id);
    }
}
